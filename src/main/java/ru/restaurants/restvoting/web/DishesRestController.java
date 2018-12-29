package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.service.DishService;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value= DishesRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishesRestController {
    static final String REST_URL = "/rest/dishes";

    private final DishService dishService;

    @Autowired
    public DishesRestController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/{restaurant_id}")
    public List<Dish> getAll(@PathVariable("restaurant_id") Integer restaurantId ) {
        return dishService.getAllByRestaurantId(restaurantId);
    }

    @PostMapping("/{restaurant_id}")
    public void voteForRestaurant(@PathVariable("restaurant_id") Integer restaurantId) {
        dishService.vote(restaurantId);
    }
}
