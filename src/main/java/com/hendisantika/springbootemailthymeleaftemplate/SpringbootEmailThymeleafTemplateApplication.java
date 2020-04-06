package com.hendisantika.springbootemailthymeleaftemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.activation.FileTypeMap;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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
        datas.put("tanggal", LocalDateTime.now());
        try {
            mailService.sendMail(RECIPIENTS, SUBJECT, "MailTemplate1", datas, new String[]{"proba.txt"});
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void sendHtmlTemplateMessageWithInlineImage_imageFileName() {
        String[] messages = {"Build and deploy a Spring Boot app on Minikube (part 1)"};
        Path p = Paths.get("images/ninja.jpg");

        Map<String, Object> datas = new HashMap<>();
        datas.put("messages", messages);
        datas.put("tanggal", LocalDateTime.now());
        datas.put("imageResourceName", p.getFileName().toString());
        try {
            mailService.sendMailWithInlineImage(RECIPIENTS, SUBJECT, "MailTemplate2", datas,
                    new String[]{"proba.txt"}, p.getFileName().toString(), "proba.jpg");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void sendHtmlTemplateMessageWithInlineImage_imageByteArray() throws Exception {
        String[] messages = {"Spring WebFlux: a basic CRUD application (part 1)"};
        Path p = Paths.get("images/girl.png");
        byte[] image = Files.readAllBytes(p);
        String contentType = FileTypeMap.getDefaultFileTypeMap().getContentType(p.toFile());

        Map<String, Object> datas = new HashMap<>();
        datas.put("messages", messages);
        datas.put("tanggal", LocalDateTime.now());
        datas.put("imageResourceName", p.getFileName().toString());
        try {
            mailService.sendMailWithInlineImage(RECIPIENTS, SUBJECT, "MailTemplate2", datas, new String[]{"proba.txt"}
                    , p.getFileName().toString(), image, contentType);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
