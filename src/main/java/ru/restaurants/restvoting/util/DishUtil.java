package ru.restaurants.restvoting.util;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.to.DishTo;

public class DishUtil {
    public static Dish createFromTo(DishTo dishTo) {
        return new Dish(null, dishTo.getDescription(), dishTo.getPrice(), dishTo.getDate());
    }
}
