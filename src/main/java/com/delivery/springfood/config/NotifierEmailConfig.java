package com.delivery.springfood.config;

import com.delivery.springfood.services.NotifierEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifierEmailConfig {

    @Bean
    public NotifierEmail notifierEmail() {
        NotifierEmail notifier = new NotifierEmail("smtp.com.br");
        notifier.setCapsLock(true);
        return notifier;
    }
}
