package com.practice.authenticationauthorisation.repositories;

import com.practice.authenticationauthorisation.modules.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCountry extends JpaRepository<Country,Integer> {
}
