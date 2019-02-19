package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.service.DishService;

import java.time.LocalDate;
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
    public List<MenuItem> getAll(@PathVariable("restaurant_id") Integer restaurantId,
                                 @RequestParam(value = "date", required = false) LocalDate date) {
        if (date == null) {
            return dishService.getAllByRestaurantId(restaurantId);
        }
        return dishService.getAllByRestaurantIdAndDate(restaurantId, date);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return dishService.listAllRestaurants();
    }
}
