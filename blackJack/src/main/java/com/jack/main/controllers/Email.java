/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vatso
 */
@Controller
public class Email {

    static String emailToRecipient, emailSubject, emailMessage;
    static final String emailFromRecipient = "<!-- Source Email Address -->";

    static ModelAndView modelViewObj;

    @Autowired
    private JavaMailSender mailSenderObj;

    @RequestMapping(value = {"/email"}, method = RequestMethod.GET)
    public ModelAndView showEmailForm(ModelMap model) {
        modelViewObj = new ModelAndView("emailForm");
        return modelViewObj;
    }

    // This Method Is Used To Prepare The Email Message And Send It To The Client
    @RequestMapping(value = "sendEmail", method = RequestMethod.POST)
    public ModelAndView sendEmailToClient(HttpServletRequest request, final @RequestParam CommonsMultipartFile attachFileObj) {

        // Reading Email Form Input Parameters      
        emailSubject = request.getParameter("subject");
        emailMessage = request.getParameter("message");
        emailToRecipient = request.getParameter("mailTo");

        // Logging The Email Form Parameters For Debugging Purpose
        System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");

        mailSenderObj.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws IOException {
                try {
                    MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    mimeMsgHelperObj.setTo(emailToRecipient);
                    mimeMsgHelperObj.setFrom(emailFromRecipient);
                    mimeMsgHelperObj.setText(emailMessage);
                    mimeMsgHelperObj.setSubject(emailSubject);
                     
                    // Determine If There Is An File Upload. If Yes, Attach It To The Client Email
                    if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
                        System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
                        mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), () -> attachFileObj.getInputStream());
                    } else {
                        System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
                    }
                } catch (MessagingException ex) {
                    System.out.println("file upload failed");
                }
            }
        });
        System.out.println("\nMessage Send Successfully.... Hurrey!\n");

        modelViewObj = new ModelAndView("successMessage", "messageObj", "Thank You! Your Email Has Been Sent!");
        return modelViewObj;
    }

}
