package com.delivery.springfood.services;

import com.delivery.springfood.config.NotifierType;
import com.delivery.springfood.enums.TypeUrgency;
import com.delivery.springfood.event.ClientActivatedEvent;
import com.delivery.springfood.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ActivationClientService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void activate(Client client) {
        client.activate();
        eventPublisher.publishEvent(new ClientActivatedEvent(client));
    }
}
