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

        Kitchen kitchen1 = new Kitchen();
        Kitchen kitchen2 = new Kitchen();
        Kitchen kitchen3 = new Kitchen();

        kitchen1.setName("Brasileira");
        kitchen2.setName("Japonesa");

        registerKitchen.save(kitchen1);
        registerKitchen.save(kitchen2);

        List<Kitchen> kitchens = registerKitchen.listAll();
        for (Kitchen kitchen: kitchens) {
            System.out.println(kitchen.getName());
        }

        Kitchen search = registerKitchen.search(1L);
        System.out.println("Cozinha retornada apatir do método de find ID: " + search.getName());

        kitchen3.setId(1L);
        kitchen3.setName("ITALIANA");
        registerKitchen.save(kitchen3);
        System.out.println("Atualizando uma cozinha existente apartir de um determinado ID: " + kitchen3.getName());

        System.out.println("Removendo: " + registerKitchen.remove(kitchen3));
    }
}
