/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.services;



import com.jack.main.player.Roles;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author vatso
 */
public interface RoleInterface {
    
    public List<Roles> getAllRoles();

    public void saveRole(List<Roles> theRole);

    public Optional<Roles> getRoles(int theId);

    public void deleteRole(int theId);
    
    
    
    
    
    
}
