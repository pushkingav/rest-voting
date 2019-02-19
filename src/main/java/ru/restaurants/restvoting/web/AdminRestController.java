package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.service.DishService;
import ru.restaurants.restvoting.to.DishTo;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.ADMIN_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    static final String ADMIN_REST_URL = "/rest/admin";

    @Autowired
    private DishService dishService;

    @PostMapping(value = "/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant created = dishService.addRestaurant(restaurant, null);
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PostMapping(value = "/dishes/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addManyDishes(@Valid @RequestBody List<DishTo> dishToList, @PathVariable Integer restaurantId) {
        dishService.addDishes(dishToList, restaurantId);
    }
}
