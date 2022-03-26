package com.delivery.springfood.jpa;

import com.delivery.springfood.SpringfoodApiApplication;
import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class QueryKitchenMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(SpringfoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRepository kitchenRepository = applicationContext.getBean(KitchenRepository.class);

        Kitchen kitchen1 = new Kitchen();
        Kitchen kitchen2 = new Kitchen();
        Kitchen kitchen3 = new Kitchen();

        kitchen1.setName("Brasileira");
        kitchen2.setName("Japonesa");

        kitchenRepository.save(kitchen1);
        kitchenRepository.save(kitchen2);

        List<Kitchen> kitchens = kitchenRepository.listAll();
        for (Kitchen kitchen : kitchens) {
            System.out.println(kitchen.getName());
        }

        Kitchen search = kitchenRepository.search(1L);
        System.out.println("Cozinha retornada apartir do método de find ID: " + search.getName());

        kitchen3.setId(1L);
        kitchen3.setName("ITALIANA");
        kitchenRepository.save(kitchen3);
        System.out.println("Atualizando uma cozinha existente apartir de um determinado ID: " + kitchen3.getName());

        System.out.println("Removendo: " + kitchenRepository.remove(kitchen3));
    }
}
