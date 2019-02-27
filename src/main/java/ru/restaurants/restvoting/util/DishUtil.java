package ru.restaurants.restvoting.util;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.to.MenuItemTo;

public class DishUtil {
    public static Dish createNewDishFromTo(MenuItemTo menuItemTo) {
        return new Dish(null, menuItemTo.getDescription());
    }

    public static MenuItem createNewMenuItemFromTo(MenuItemTo menuItemTo) {
        return new MenuItem(null, menuItemTo.getPrice(), menuItemTo.getDate());
    }
}
