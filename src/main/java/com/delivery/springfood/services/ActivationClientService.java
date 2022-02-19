package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivationClientService {

    @Autowired
    private List<Notifier> notifiers;

    public void activate(Client client) {
        client.activate();

        for (Notifier notifier : notifiers) {
            notifier.notify(client, "Seu cadastro no sistema está ativo!");
        }
    }
}
