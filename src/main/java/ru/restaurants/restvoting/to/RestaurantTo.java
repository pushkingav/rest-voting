package ru.restaurants.restvoting.to;

import ru.restaurants.restvoting.model.Restaurant;

import javax.validation.constraints.NotNull;

public class RestaurantTo extends BaseTo {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static RestaurantTo createFromRestaurant(Restaurant restaurant) {
        RestaurantTo to = new RestaurantTo();
        to.setId(restaurant.getId());
        to.setName(restaurant.getName());
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestaurantTo)) return false;
        RestaurantTo that = (RestaurantTo) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
