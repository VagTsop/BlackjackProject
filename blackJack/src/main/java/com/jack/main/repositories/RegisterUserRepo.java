/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.repositories;

import com.jack.main.player.BlackjackPlayers;
import com.jack.main.dto.RegisterUserDTO;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vatso
 */
@Repository
public interface RegisterUserRepo extends CrudRepository<BlackjackPlayers, Integer> {

    public BlackjackPlayers findByUsername(String username);

    public BlackjackPlayers save(RegisterUserDTO userdto);

    public BlackjackPlayers findByEmail(String email);

    @Query(value = "SELECT * FROM blackjack_players P WHERE P.ROLE_ID=2;", nativeQuery = true)
    public List<BlackjackPlayers> fetchPlayers();

}
