package com.practice.authenticationauthorisation.repositories;

import com.practice.authenticationauthorisation.modules.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoState extends JpaRepository<State,Integer> {
}
