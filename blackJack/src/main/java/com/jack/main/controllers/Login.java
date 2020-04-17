/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.controllers;

import com.jack.main.player.BlackjackPlayers;
import com.jack.main.player.RegisterUserDTO;
import com.jack.main.services.RegisterUserInterface;
import com.jack.main.validator.RegisterValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

@RequestMapping(value = "/signIn")
public class Login {

    @Autowired
    private RegisterUserInterface loginuserInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new RegisterValidator());
    }

    @ModelAttribute("registeredUser")
    public RegisterUserDTO userdto() {
        return new RegisterUserDTO();

    }

    @GetMapping(value = "/showLoginForm")
    public String showLogin(Model theModel) {

        BlackjackPlayers theBlackjackPlayer = new BlackjackPlayers();

        theModel.addAttribute("registeredUser", theBlackjackPlayer);

        return "LoginForm";
    }

    @PostMapping("/signedIn")
    public String login(@Valid RegisterUserDTO userdto, BindingResult result) {

        BlackjackPlayers theBlackjackPlayer = loginuserInterface.findByUsername(userdto.getUsername());
        try {

            if ((userdto == null) || (!passwordEncoder.matches(userdto.getPassword(), theBlackjackPlayer.getPassword()))) {
            }
        } catch (NullPointerException e) {
            System.out.println("null pointer exception cached");

            return "ErrorPage";

        }

        return "Welcome";
    }

}
