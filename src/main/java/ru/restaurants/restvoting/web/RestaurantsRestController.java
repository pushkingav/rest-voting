package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.service.DishService;
import ru.restaurants.restvoting.to.MenuItemTo;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value = RestaurantsRestController.RESTAURANTS_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantsRestController {
    public static final String RESTAURANTS_REST_URL = "/rest/restaurants";

    @Autowired
    private DishService dishService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant created = dishService.addRestaurant(restaurant, null);
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PostMapping(value = "/{restaurantId}/menu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createMenuItems(@Valid @RequestBody List<MenuItemTo> menuItemToList, @PathVariable Integer restaurantId) {
        dishService.addDishes(menuItemToList, restaurantId);
    }

    @GetMapping("/{restaurantId}/menu")
    public List<MenuItem> getAllMenuItems(@PathVariable("restaurantId") Integer restaurantId,
                                          @RequestParam(value = "date", required = false) LocalDate date) {
        if (date == null) {
            return dishService.getAllByRestaurantId(restaurantId);
        }
        return dishService.getAllByRestaurantIdAndDate(restaurantId, date);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAllRestaurants() {
        return dishService.getAllRestaurants();
    }
}
