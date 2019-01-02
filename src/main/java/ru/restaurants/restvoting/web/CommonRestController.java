package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.service.DishService;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value= CommonRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CommonRestController {
    static final String REST_URL = "/rest";

    private final DishService dishService;

    @Autowired
    public CommonRestController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes/{restaurant_id}")
    public List<Dish> getAll(@PathVariable("restaurant_id") Integer restaurantId ) {
        return dishService.getAllByRestaurantId(restaurantId);
    }

    @GetMapping("/restaurants/list")
    public List<Restaurant> getAllRestaurants() {
        return dishService.listAllRestaurants();
    }
}
