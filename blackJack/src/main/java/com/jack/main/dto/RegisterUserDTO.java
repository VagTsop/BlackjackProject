/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.dto;

import com.jack.main.player.Roles;


/**
 *
 * @author vatso
 */
public class RegisterUserDTO {

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private String matchingpassword;
    
    private String email;

    private String fileName;
    
    private byte[] fileData;

    private  Roles roleId; 

    public RegisterUserDTO() {
    }

    
    public RegisterUserDTO(String firstname, String lastname, String username, String password, String matchingpassword, String email, String fileName, byte[] fileData, Roles roleId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.matchingpassword = matchingpassword;
        this.email = email;
        this.fileName = fileName;
        this.fileData = fileData;
        this.roleId = roleId;
    }
    
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingpassword() {
        return matchingpassword;
    }

    public void setMatchingpassword(String matchingpassword) {
        this.matchingpassword = matchingpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

  
     public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }
    
    
    
}
