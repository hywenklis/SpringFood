package com.delivery.springfood.services;

import com.delivery.springfood.config.NotifierProperties;
import com.delivery.springfood.config.NotifierType;
import com.delivery.springfood.enums.TypeUrgency;
import com.delivery.springfood.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NotifierType(TypeUrgency.URGENCY)
@Component
public class NotifierEmail implements Notifier{

    @Autowired
    private NotifierProperties notifierProperties;

    @Override
    public void notify(Client client, String message) {

        System.out.println("Host: " + notifierProperties.getHostServer());
        System.out.println("Porta: " + notifierProperties.getPortServer());

        System.out.printf("Notificando %s através do email %s: %s\n",
                client.getName(), client.getEmail(), message);
    }
}
