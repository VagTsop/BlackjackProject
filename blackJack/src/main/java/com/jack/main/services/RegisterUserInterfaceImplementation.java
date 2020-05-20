/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.services;


import com.jack.main.player.BlackjackPlayers;
import com.jack.main.dto.RegisterUserDTO;

import com.jack.main.repositories.RegisterUserRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 *
 * @author vatso
 */
@Service
@Transactional
public class RegisterUserInterfaceImplementation implements RegisterUserInterface {

    
    
    
    
    
    @Autowired
    private RegisterUserRepo registerUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public BlackjackPlayers findByUsername(String username) {
        return registerUserRepo.findByUsername(username);
    }
     
   
    @Override
         public  BlackjackPlayers findByEmail(String email){
         return registerUserRepo.findByEmail(email);
     }

    @Override
    public BlackjackPlayers save(RegisterUserDTO userdto) {

        BlackjackPlayers theBlackjackPlayer = new BlackjackPlayers();

        theBlackjackPlayer.setFirstname(userdto.getFirstname());
        theBlackjackPlayer.setLastname(userdto.getLastname());
        theBlackjackPlayer.setUsername(userdto.getUsername());
        theBlackjackPlayer.setEmail(userdto.getEmail());
        theBlackjackPlayer.setPassword(passwordEncoder.encode(userdto.getPassword()));
        theBlackjackPlayer.setRoleId(userdto.getRoleId());
        
        return registerUserRepo.save(theBlackjackPlayer);

    }

    @Override
    public List<BlackjackPlayers> fetchPlayers() {
        return (List)registerUserRepo.fetchPlayers();
    }




    

 

}
