package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ActivationClientService {

    private NotifierEmail notifierEmail;

    public void activate(Client client) {
        client.activate();
        notifierEmail.notify(client, "Seu cadastro no sistema está ativo!");
    }
}
