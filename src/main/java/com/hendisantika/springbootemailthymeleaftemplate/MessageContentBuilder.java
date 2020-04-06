package com.hendisantika.springbootemailthymeleaftemplate;

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
public interface MessageContentBuilder {
    String buildMessage(String templateName, Map<String, Object> datas);
}
