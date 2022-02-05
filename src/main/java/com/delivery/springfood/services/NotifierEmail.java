package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class NotifierEmail implements Notifier{

    private boolean capsLock;
    private final String hostServerSmtp;

    public NotifierEmail(String hostServerSmtp) {
        this.hostServerSmtp = hostServerSmtp;
    }

    @Override
    public void notify(Client client, String message) {
        if (capsLock) {
            message = message.toUpperCase(Locale.ROOT);
        }
        System.out.printf("Notificando %s através do email %s usando SMTP: %s: %s\n",
                client.getName(), client.getEmail(), hostServerSmtp, message);
    }

    public void setCapsLock(boolean capsLock) {
        this.capsLock = capsLock;
    }
}
