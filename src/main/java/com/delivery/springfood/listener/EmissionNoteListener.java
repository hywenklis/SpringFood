package com.delivery.springfood.listener;

import com.delivery.springfood.event.ClientActivatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissionNoteListener {

    @EventListener
    public void clientActivatedListener(ClientActivatedEvent event) {
        System.out.println("Emitindo nota fiscal para o cliente " + event.getClient().getName());
    }
}
