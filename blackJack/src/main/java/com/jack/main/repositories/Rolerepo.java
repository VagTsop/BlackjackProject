/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.repositories;



import com.jack.main.player.Roles;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vatso
 */
@Repository
public interface Rolerepo extends CrudRepository <Roles,Integer>{

    public void save(List<Roles> theroles);

   
   
}
