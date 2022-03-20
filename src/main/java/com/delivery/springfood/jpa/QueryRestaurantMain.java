package com.delivery.springfood.jpa;

import com.delivery.springfood.SpringfoodApiApplication;
import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class QueryRestaurantMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(SpringfoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);

        Restaurant restaurant1 = new Restaurant();
        Restaurant restaurant2 = new Restaurant();
        Restaurant restaurant3 = new Restaurant();

        restaurant1.setName("Restaurante Brasileiro");
        restaurant2.setName("Restaurante Japones");
        restaurant3.setName("Restaurante Italiano");

        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);
        restaurantRepository.save(restaurant3);

        List<Restaurant> restaurants = restaurantRepository.listAll();
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName());
        }

        Restaurant search = restaurantRepository.search(1L);
        System.out.println("Restaurante retornado apatir do método de find ID: " + search.getName());

        restaurant3.setId(1L);
        restaurant3.setName("Restaurante Frânces");
        restaurantRepository.save(restaurant3);
        System.out.println("Atualizando um restaurante existente apartir de um determinado ID: " + restaurant3.getName());

        System.out.println("Removendo: " + restaurantRepository.remove(restaurant3));
    }
}
