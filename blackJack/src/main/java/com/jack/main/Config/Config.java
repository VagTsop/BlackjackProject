/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author vatso
 */
@Configuration

public class Config   {
    
     @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    
    }
    
  
    
    
    
    
}
