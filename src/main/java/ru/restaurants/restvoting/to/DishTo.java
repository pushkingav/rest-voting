package ru.restaurants.restvoting.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class DishTo {
    private String description;
    private BigDecimal price;
    private LocalDateTime dateTime;
    private Integer restaurant_id;

    public DishTo() {
    }

    public DishTo(String description, BigDecimal price, LocalDateTime dateTime, Integer restaurant_id) {
        this.description = description;
        this.price = price;
        this.dateTime = dateTime;
        this.restaurant_id = restaurant_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishTo dishTo = (DishTo) o;
        return description.equals(dishTo.description) &&
                price.equals(dishTo.price) &&
                dateTime.equals(dishTo.dateTime) &&
                restaurant_id.equals(dishTo.restaurant_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, dateTime, restaurant_id);
    }
}
