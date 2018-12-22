package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.service.DishService;
import ru.restaurants.restvoting.service.UserService;
import ru.restaurants.restvoting.to.DishTo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.ADMIN_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    static final String ADMIN_REST_URL = "/rest/admin/";

    @Autowired
    private DishService dishService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addDishes(@RequestBody List<DishTo> dishList) {
        List<Dish> dishes = new ArrayList<>();
        for(DishTo dishTo : dishList) {
            Restaurant restaurant = userService.getRestaurantById(dishTo.getRestaurant_id());
            Dish dish = new Dish(null, dishTo.getDescription(), dishTo.getPrice(), dishTo.getDateTime());
            dish.setRestaurant(restaurant);
            dishes.add(dish);
        }
        dishService.addDishes(dishes);
    }
}
