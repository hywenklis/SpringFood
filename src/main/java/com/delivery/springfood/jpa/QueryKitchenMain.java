package com.delivery.springfood.jpa;

import com.delivery.springfood.SpringfoodApiApplication;
import com.delivery.springfood.domain.model.Kitchen;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class QueryKitchenMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(SpringfoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RegisterKitchen registerKitchen = applicationContext.getBean(RegisterKitchen.class);
        List<Kitchen> kitchens = registerKitchen.listAll();
        for (Kitchen kitchen: kitchens) {
            System.out.println(kitchen.getName());
        }
    }
}
