package dev.top.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.ActionButton;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueForm;
import dev.top.repos.CollegueRepository;

@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueRepository collegueRepo;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
	}

	@GetMapping("/{pseudo}")
	public Collegue findOne(@PathVariable String pseudo) {
		Collegue collegue = collegueRepo.findByPseudo(pseudo);
		return collegue;
	}

	@PatchMapping("/{pseudo}")
	public Collegue actionAvis(@PathVariable String pseudo, @RequestBody ActionButton action) {
		Collegue collegue = collegueRepo.findByPseudo(pseudo);
		if (action.getAction() == Avis.AIMER) {
			collegue.setScore(collegue.getScore() + 10);
		} else {
			collegue.setScore(collegue.getScore() - 5);
		}
		collegueRepo.save(collegue);
		return collegue;
	}

	@GetMapping("/matricules")
	public static List<String> findMatriculeList() {
		RestTemplate rt = new RestTemplate();
		CollegueForm[] tabColleguesForm = rt.getForObject("http://collegues-api.cleverapps.io/collegues",
				CollegueForm[].class);
		List<String> matricules = new ArrayList<String>();
		for (CollegueForm matricule : tabColleguesForm) {
			matricules.add(matricule.getMatricule());
		}
		return matricules;
	}

	@PostMapping("/nouveau")
	public ResponseEntity<?> creerCollegue(@RequestBody CollegueForm collegueF) {
		int score = 0;
		Long matricule = findMatriculeList().stream().filter(matriculeApi -> matriculeApi.equals(collegueF.getMatricule())).count();
		System.out.println(matricule);
		if (matricule == 1) {
			String cFPseudo = collegueF.getPseudo();
			if (collegueRepo.findByPseudo(cFPseudo) == null) {
				Collegue collegue = new Collegue(cFPseudo, Arrays.asList(collegueF.getImageUrl()), score);
				collegueRepo.save(collegue);
				return ResponseEntity.status(HttpStatus.OK).body("ok");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pseudo already exist");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad matricule");
		}
	}
}
