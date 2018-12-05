package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.ActionButton;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
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
}
