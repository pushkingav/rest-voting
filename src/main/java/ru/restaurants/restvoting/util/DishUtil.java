package ru.restaurants.restvoting.util;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.to.DishTo;

public class DishUtil {
    public static Dish createNewDishFromTo(DishTo dishTo) {
        return new Dish(null, dishTo.getDescription());
    }

    public static MenuItem createNewMenuItemFromTo(DishTo dishTo) {
        return new MenuItem(null, dishTo.getPrice(), dishTo.getDate());
    }
}
