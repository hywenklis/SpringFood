package com.delivery.springfood.services;

import com.delivery.springfood.config.NotifierType;
import com.delivery.springfood.enums.TypeUrgency;
import com.delivery.springfood.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivationClientService {

    @NotifierType(TypeUrgency.URGENCY)
    @Autowired
    private Notifier notifier;

    public void activate(Client client) {
        client.activate();
        notifier.notify(client, "Seu cadastro no sistema está ativo!");
    }
}
