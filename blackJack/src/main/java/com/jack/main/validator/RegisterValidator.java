/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.validator;

import com.jack.main.player.BlackjackPlayers;
import com.jack.main.dto.RegisterUserDTO;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author vatso
 */
public class RegisterValidator implements Validator {
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;

          private static final Pattern EMAIL_REGEX =
          Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");
    
    
    @Override
    public boolean supports(Class arg0) {
        return RegisterUserDTO.class.equals(arg0) || BlackjackPlayers.class.equals(arg0);
    }

    @Override
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "firstname", "firstname.empty");
        ValidationUtils.rejectIfEmpty(e, "lastname", "lastname.empty");
        ValidationUtils.rejectIfEmpty(e, "username", "username.empty");
        ValidationUtils.rejectIfEmpty(e, "email", "email.empty");
        ValidationUtils.rejectIfEmpty(e, "password", "password.empty");
        ValidationUtils.rejectIfEmpty(e, "matchingpassword", "matchingpassword.empty");

        RegisterUserDTO userdto = (RegisterUserDTO) obj;
        if (!userdto.getPassword().equals(userdto.getMatchingpassword())) {
            e.rejectValue("matchingpassword", "matchingpassword.notequal");

        }
    
    
    if (userdto.getEmail() != null && !EMAIL_REGEX.matcher(userdto.getEmail()).matches()) {
          e.rejectValue("email", "user.email.invalid");
      }
    
    
    
    
    
    
    
    
    }
    
    
    
}
