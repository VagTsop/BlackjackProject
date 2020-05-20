 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.services;

import java.util.Date;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author vatso
 */
@Service("EmailInterface")
public class EmailInterfaceImplementation implements EmailInterface {
    
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    
    @Override
    public void send(String fromAddress, String toAddress, String subject, String content) throws Exception {
        
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(fromAddress);
        mimeMessageHelper.setTo(toAddress);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content,true);
        mimeMessageHelper.setSentDate(new Date());
        javaMailSender.send(mimeMessage);
        
        
        
    }
    
    
}
