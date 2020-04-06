package com.hendisantika.springbootemailthymeleaftemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Map;

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

    public void sendMailWithInlineImage(String[] recipients, String subject, String templateName,
                                        Map<String, Object> datas, String[] attachments, String imageResourceName,
                                        byte[] imageBytes, String imageContentType) {

        final InputStreamSource imageSource = new ByteArrayResource(imageBytes);

        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, ISMULTIPART, encoding);
                composeMessageHeader(recipients, subject, attachments, messageHelper);
                messageHelper.setText(contentBuilder.buildMessage(templateName, datas), ISHTML);
                messageHelper.addInline(imageResourceName, imageSource, imageContentType);
            }
        };

        mailSender.send(mimeMessagePreparator);
    }
}
