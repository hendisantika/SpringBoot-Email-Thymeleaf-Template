package com.hendisantika.springbootemailthymeleaftemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootEmailThymeleafTemplateApplication {

    private static final String[] RECIPIENTS = {"email@konohagakure.co.jp"};
    private static final String SUBJECT = "Spring Boot Email Thymelef Template";

    @Autowired
    private MailService mailService;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmailThymeleafTemplateApplication.class, args);
    }

}
