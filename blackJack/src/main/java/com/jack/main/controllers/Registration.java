/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.controllers;

import com.jack.main.player.BlackjackPlayers;
import com.jack.main.dto.RegisterUserDTO;
import com.jack.main.player.Roles;
import com.jack.main.services.RegisterUserInterface;
import com.jack.main.services.RoleInterface;
import com.jack.main.validator.RegisterValidator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author vatso
 */
@Controller

@RequestMapping(value = "/registration")

public class Registration {

    @Autowired
    RoleInterface roleint;

    @Autowired
    RegisterUserInterface registerUserInterface;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new RegisterValidator());
    }

    @ModelAttribute("newuser")
    public RegisterUserDTO userdto() {
        return new RegisterUserDTO();

    }

    @RequestMapping("/showRegisterForm")
    public String showForm(Model theModel) {

        RegisterUserDTO userdto = new RegisterUserDTO();

        List<Roles> theroles = roleint.getAllRoles();

        theModel.addAttribute("newuser", userdto);
        theModel.addAttribute("rolesapp", theroles);

        return "registrationForm";

    }

    @PostMapping("registerUser")
    public String registerUserAccount(@ModelAttribute("newuser") @Valid RegisterUserDTO userdto,
            BindingResult result, RedirectAttributes redirectAttributes, Model theModel) {

        BlackjackPlayers theBlackjackPlayer = registerUserInterface.findByUsername(userdto.getUsername());

        if (theBlackjackPlayer != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");

        }

        String email = userdto.getEmail();
        if (registerUserInterface.findByEmail(email) != null) {
            result.rejectValue("email", null, "Email address is already in use.");
           
        }

        if (result.hasErrors()) {
          
            List<Roles> theroles = roleint.getAllRoles();
            theModel.addAttribute("rolesapp", theroles);
            return "registrationForm";
           
        }

        theModel.addAttribute("newuser", userdto);

        registerUserInterface.save(userdto);
        // return "redirect:/showLoginForm";
        redirectAttributes.addFlashAttribute("username", userdto.getUsername());

        return "redirect:/signIn/showLoginForm";

    }

}
