package com.practice.authenticationauthorisation.controllers;

import com.practice.authenticationauthorisation.modules.User;
import com.practice.authenticationauthorisation.repositories.RepoUser;
import com.practice.authenticationauthorisation.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private SignUpService signUpService;
    private RepoUser repoUser;
    @PostMapping("/signup")
    public @ResponseBody User signup(@RequestBody User user)
    {
        return signUpService.signup(user);
    }
}
