package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ActivationClientService {

    private final Notifier notifier;

    public ActivationClientService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void activate(Client client) {
        client.activate();
        notifier.notify(client, "Seu cadastro no sistema está ativo!");
    }
}
