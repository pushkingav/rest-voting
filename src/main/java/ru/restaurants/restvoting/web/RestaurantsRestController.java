package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.service.DishService;
import ru.restaurants.restvoting.service.RestaurantService;
import ru.restaurants.restvoting.to.RestaurantTo;

import javax.validation.Valid;
import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value = RestaurantsRestController.RESTAURANTS_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantsRestController {
    public static final String RESTAURANTS_REST_URL = "/rest/restaurants";

    @Autowired
    private DishService dishService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> add(@Valid @RequestBody Restaurant restaurant) {
        Restaurant created = restaurantService.addRestaurant(restaurant, null);
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> edit(@Valid @RequestBody Restaurant restaurant, @PathVariable("id") int id) {
        Restaurant edited = restaurantService.editRestaurant(id, restaurant.getName());
        if (edited != null) {
            return ResponseEntity.ok(edited);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> getAll() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping(value = "/menu",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAllWithMenuItems() {
        return restaurantService.getAllRestaurantsWithMenu();
    }
}
