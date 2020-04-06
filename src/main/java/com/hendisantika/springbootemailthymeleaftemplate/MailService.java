package com.hendisantika.springbootemailthymeleaftemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-email-thymeleaf-template
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/04/20
 * Time: 14.03
 */
@Service
public class MailService {
    private static final boolean ISHTML = true;
    private static final boolean ISMULTIPART = true;
    private static final String encoding = "UTF-8";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MessageContentBuilder contentBuilder;

    @Value("${mail.from}")
    private String from;
}
