package com.practice.authenticationauthorisation.repositories;

import com.practice.authenticationauthorisation.modules.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCity extends JpaRepository<City,Integer> {
}
