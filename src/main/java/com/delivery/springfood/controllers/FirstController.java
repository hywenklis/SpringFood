package com.delivery.springfood.controllers;

import com.delivery.springfood.models.Client;
import com.delivery.springfood.services.ActivationClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    private final ActivationClientService activationClientService;

    public FirstController(ActivationClientService activationClientService) {
        this.activationClientService = activationClientService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Client maria = new Client("Maria", "maria@txta.com", "53321586248");
        activationClientService.activate(maria);
        return "Hello!";
    }
}
