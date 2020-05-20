/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.controllers;

import com.jack.main.model.Contact;
import com.jack.main.services.EmailInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author vatso
 */
@Controller
@RequestMapping(value= "/contact")
public class ContactController {

    @Autowired
    EmailInterface mailService;
    
    @ModelAttribute("contact")
    public Contact contact() {
        return new Contact();

    }
    
    
     @GetMapping(value = "/showContactForm")
    public String showLogin(Model theModel) {

        Contact contact = new Contact();

        theModel.addAttribute("contact", contact);

        return "contactForm";
    }
    
    @RequestMapping(value = "send", method = RequestMethod.POST)
    public String send(@ModelAttribute("contact") Contact contact, ModelMap modelMap, RedirectAttributes redirectAttributes){
        
        try {
        String content = "Name: " + contact.getName();
        content += "<br>Phone: " + contact.getPhone();
        content += "<br>Address: " + contact.getAddress();
        mailService.send(contact.getEmail(), contact.getAddress(), contact.getSubject(), content);
         modelMap.put("msg", "Done!");
        } catch (Exception e) {
          modelMap.put("msg", e.getMessage());
        }
       
         modelMap.addAttribute("contact", contact);
         
          redirectAttributes.addFlashAttribute("address", contact.getAddress());
         
        return "playerWelcomePage";
    }

}
