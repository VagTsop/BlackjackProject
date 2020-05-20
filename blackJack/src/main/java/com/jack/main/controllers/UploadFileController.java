/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.controllers;

import com.jack.main.player.BlackjackPlayers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

/**
 *
 * @author vatso
 */

@Controller
@RequestMapping(value = "/photo")
public class UploadFileController implements ServletContextAware {
    
      private ServletContext servletContext;

      
      @Autowired
      MultipartResolver multipartResolven;
      
      
       @ModelAttribute("userPhoto")
    public BlackjackPlayers theBlackjackPlayer() {
        return new BlackjackPlayers();

    }
      
     @RequestMapping("/showPhotoForm")
    public String index(ModelMap modelMap) {
        modelMap.put("userPhoto", new BlackjackPlayers());
        return "uploadPhotoForm";
    }
    
    
    
    
    
    
     @RequestMapping(value = "/save")
    public String save(@ModelAttribute("userPhoto") BlackjackPlayers theBlackjackPlayer, @RequestParam(value = "file") MultipartFile file,
            ModelMap modelMap) {
        String fileName = saveImage(file);
        theBlackjackPlayer.setProfilePhotoName(fileName);
        modelMap.put("userPhoto", theBlackjackPlayer);
        return "photo/uploadPhotoSuccess";
    }

    private String saveImage(MultipartFile multipartFile) {
        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(servletContext.getRealPath("/resources/img/" + multipartFile.getOriginalFilename()));
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
    
    
    
    
    
    
}
