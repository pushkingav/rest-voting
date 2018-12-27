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
@RequestMapping(value=VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/dishes";

    private final DishService dishService;

    @Autowired
    public VoteRestController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAll() {
        return dishService.getAll();
    }

    @GetMapping("/{id}")
    public List<Dish> getDishesForRestaurantAndDate(@PathVariable("id") Integer id) {
        return dishService.getAllByRestaurant(id);
    }

    @PostMapping("/{restaurant_id}")
    public void voteForRestaurant(@PathVariable("restaurant_id") Integer restaurantId) {
        dishService.vote(restaurantId);
    }
}
