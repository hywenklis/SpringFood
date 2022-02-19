package com.delivery.springfood.services;

import com.delivery.springfood.config.NotifierType;
import com.delivery.springfood.enums.TypeUrgency;
import com.delivery.springfood.models.Client;
import org.springframework.stereotype.Component;

@NotifierType(TypeUrgency.NORMAL)
@Component
public class NotifierSMS implements Notifier {
    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                client.getName(), client.getTelephone(), message);
    }
}
