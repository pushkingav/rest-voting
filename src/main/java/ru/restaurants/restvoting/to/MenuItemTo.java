package ru.restaurants.restvoting.to;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class MenuItemTo {
    @NotNull
    private String description;
    
    @NotNull
    private BigDecimal price;
    
    @NotNull
    private LocalDate date;
    
    private Integer restaurantId;

    public MenuItemTo() {
    }

    public MenuItemTo(String description, BigDecimal price, LocalDate date, Integer restaurantId) {
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
        MenuItemTo menuItemTo = (MenuItemTo) o;
        return description.equals(menuItemTo.description) &&
                price.equals(menuItemTo.price) &&
                date.equals(menuItemTo.date) &&
                restaurantId.equals(menuItemTo.restaurantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, date, restaurantId);
    }
}
