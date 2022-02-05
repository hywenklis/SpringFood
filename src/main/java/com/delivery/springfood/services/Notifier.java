package com.delivery.springfood.services;

import com.delivery.springfood.models.Client;

public interface Notifier {
    void notify(Client client, String message);
}
