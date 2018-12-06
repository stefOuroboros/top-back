package dev.top.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<String> findMatriculeList() {
		RestTemplate rt = new RestTemplate();
		CollegueForm[] tabColleguesForm= rt.getForObject("http://collegues-api.cleverapps.io/collegues", CollegueForm[].class);
		List<String> matricules = new ArrayList<String>();
		for (CollegueForm matricule: tabColleguesForm) {
			matricules.add(matricule.getMatricule());
		}
		return matricules;
	}
}
