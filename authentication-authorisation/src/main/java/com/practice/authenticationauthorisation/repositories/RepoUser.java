package com.practice.authenticationauthorisation.repositories;

import com.practice.authenticationauthorisation.modules.User;
import org.springframework.data.repository.CrudRepository;

public interface RepoUser extends CrudRepository<User,Integer> {

}