package dev.top.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

}
