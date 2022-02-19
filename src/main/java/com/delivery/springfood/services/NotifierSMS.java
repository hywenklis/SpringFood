package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;
import org.springframework.stereotype.Component;

@Component
public class NotifierSMS implements Notifier {
    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                client.getName(), client.getTelephone(), message);
    }
}