package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;
import org.springframework.stereotype.Component;

@Component
public class NotifierEmail {

    public void notify(Client client, String message) {
        System.out.printf("Notificando %s através do email %s: %s\n", client.getName(), client.getEmail(), message);
    }
}
