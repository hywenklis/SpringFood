package com.delivery.springfood.listener;

import com.delivery.springfood.config.NotifierType;
import com.delivery.springfood.enums.TypeUrgency;
import com.delivery.springfood.event.ClientActivatedEvent;
import com.delivery.springfood.services.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    @NotifierType(TypeUrgency.URGENCY)
    private Notifier notifier;

    @EventListener
    public void clientActivatedListener(ClientActivatedEvent event) {
        notifier.notify(event.getClient(), "Seu cadastro no sistema está ativo!");
    }
}
