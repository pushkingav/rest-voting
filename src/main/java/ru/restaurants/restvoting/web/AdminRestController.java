package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.service.DishService;

import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.ADMIN_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    static final String ADMIN_REST_URL = "/rest/admin/";

    @Autowired
    private DishService dishService;

    @PostMapping(value = "/add/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addDish(@RequestBody Dish dish, @PathVariable("id") Integer restaurant_id) {
        dishService.create(dish, restaurant_id);
    }

    @PostMapping(value = "/add/many/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addManyDishes(@RequestBody List<Dish> dishes, @PathVariable Integer id) {
        dishService.addDishes(dishes, id);
    }
}
