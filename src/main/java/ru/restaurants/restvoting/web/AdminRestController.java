package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.service.DishService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.ADMIN_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    static final String ADMIN_REST_URL = "/rest/admin";

    @Autowired
    private DishService dishService;

    @PostMapping(value = "/restaurants/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant created = dishService.addRestaurant(restaurant, null);
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PostMapping(value = "/dishes/add/{restaurant_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addDish(@Valid @RequestBody Dish dish, @PathVariable("restaurant_id") Integer restaurantId) {
        dishService.create(dish, restaurantId);
    }

    @PostMapping(value = "/dishes/add/many/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addManyDishes(@Valid @RequestBody List<Dish> dishes, @PathVariable Integer id) {
        dishService.addDishes(dishes, id);
    }
}
