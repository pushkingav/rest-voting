package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.service.DishService;
import ru.restaurants.restvoting.to.MenuItemTo;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value = DishRestController.RESTAURANTS_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController {
    public static final String RESTAURANTS_REST_URL = "/rest/dishes";

    @Autowired
    private DishService dishService;

    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addByRestaurantId(@Valid @RequestBody List<MenuItemTo> menuItemToList, @PathVariable Integer restaurantId) {
        dishService.addDishes(menuItemToList, restaurantId);
    }

    @GetMapping("/{restaurantId}")
    public List<MenuItem> getByRestaurantId(@PathVariable("restaurantId") Integer restaurantId,
                                                   @RequestParam(value = "date", required = false) LocalDate date) {
        if (date == null) {
            return dishService.getAllByRestaurantId(restaurantId);
        }
        return dishService.getAllByRestaurantIdAndDate(restaurantId, date);
    }
}
