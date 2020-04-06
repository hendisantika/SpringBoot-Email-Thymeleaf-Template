package com.hendisantika.springbootemailthymeleaftemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringbootEmailThymeleafTemplateApplication implements CommandLineRunner {

    private static final String[] RECIPIENTS = {"email@konohagakure.co.jp"};
    private static final String SUBJECT = "Spring Boot Email Thymelef Template";

    @Autowired
    private MailService mailService;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmailThymeleafTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sendNormalTextMessage();
        sendHtmlTemplateMessage();
        sendHtmlTemplateMessageWithInlineImage_imageFileName();
        sendHtmlTemplateMessageWithInlineImage_imageByteArray();
    }

    private void sendNormalTextMessage() {
        try {
            mailService.sendMailText(RECIPIENTS, SUBJECT, "Ez egy lev�l t�rzs", new String[]{"proba.txt"});
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void sendHtmlTemplateMessage() {
        String[] messages = {"Containerizing your Spring boot application with Docker"};
        Map<String, Object> datas = new HashMap<>();
        datas.put("messages", messages);
        try {
            mailService.sendMail(RECIPIENTS, SUBJECT, "MailTemplate1", datas, new String[]{"proba.txt"});
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
