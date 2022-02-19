package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ActivationClientService {

    @Qualifier("urgent")
    @Autowired
    private Notifier notifier;

    public void activate(Client client) {
        client.activate();
        notifier.notify(client, "Seu cadastro no sistema está ativo!");
    }
}
