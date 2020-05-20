/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.services;



import com.jack.main.player.Roles;
import com.jack.main.repositories.Rolerepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vatso
 */
@Service
@Transactional
public class RoleInterfaceImplementation implements RoleInterface {

    @Autowired
    Rolerepo roleRepo;

    @Override
    public List<Roles> getAllRoles() {
       List<Roles> theroles =  (List<Roles>) roleRepo.findAll();
       return theroles;
    }

    @Override
    public void saveRole(List <Roles> theRole) {
        roleRepo.save(theRole);
    }

    @Override
    public Optional<Roles> getRoles(int theId) {
       return roleRepo.findById(theId); 
    }

    @Override
    public void deleteRole(int theId) {
       roleRepo.deleteById(theId);
    }

   
    
}
