package ru.restaurants.restvoting.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class DishTo {
    private String description;
    private BigDecimal price;
    private LocalDate date;
    private Integer restaurantId;

    public DishTo() {
    }

    public DishTo(String description, BigDecimal price, LocalDate date, Integer restaurantId) {
        this.description = description;
        this.price = price;
        this.date = date;
        this.restaurantId = restaurantId;
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

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishTo dishTo = (DishTo) o;
        return description.equals(dishTo.description) &&
                price.equals(dishTo.price) &&
                date.equals(dishTo.date) &&
                restaurantId.equals(dishTo.restaurantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, date, restaurantId);
    }
}
