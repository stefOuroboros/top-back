package dev.top.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Collegue;
import dev.top.entities.CollegueForm;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {
	Collegue findByPseudo(String pseudo);
	Collegue findById(int id);
}
