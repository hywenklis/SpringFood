package com.delivery.springfood.event;

import com.delivery.springfood.models.Client;

public class ClientActivatedEvent {

    private Client client;

    public ClientActivatedEvent(Client client) {
        super();
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
