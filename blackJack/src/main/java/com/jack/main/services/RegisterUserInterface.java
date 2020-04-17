/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.services;

import com.jack.main.player.BlackjackPlayers;
import com.jack.main.player.RegisterUserDTO;





/**
 *
 * @author vatso
 */
public interface RegisterUserInterface {

    public BlackjackPlayers findByUsername(String username);

    public BlackjackPlayers save(RegisterUserDTO userdto);
    
    public  BlackjackPlayers findByEmail(String email);

//    public boolean checkpass(LoginUserDTO userdto);
    
}
