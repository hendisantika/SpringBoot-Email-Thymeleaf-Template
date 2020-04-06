package com.hendisantika.springbootemailthymeleaftemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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
public class MessageContentBuilder {
    @Autowired
    private TemplateEngine templateEngine;

    public String buildMessage(String templateName, Map<String, Object> datas) {
        Context context = new Context();
        for (Map.Entry<String, Object> entry : datas.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }
        return templateEngine.process(templateName, context);
    }

}
