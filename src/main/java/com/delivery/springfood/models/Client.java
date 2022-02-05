package com.delivery.springfood.models;

public class Client {

    private final String name;
    private final String email;
    private final String telephone;
    private Boolean active = false;

    public Client(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public Boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }
}
