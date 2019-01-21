package ru.restaurants.restvoting.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class DishTo {
    private String description;
    private BigDecimal price;
    private LocalDate date;
    private Integer restaurant_id;

    public DishTo() {
    }

    public DishTo(String description, BigDecimal price, LocalDate date, Integer restaurant_id) {
        this.description = description;
        this.price = price;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
                date.equals(dishTo.date) &&
                restaurant_id.equals(dishTo.restaurant_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, date, restaurant_id);
    }
}
