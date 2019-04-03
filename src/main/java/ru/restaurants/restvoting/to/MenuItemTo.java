package ru.restaurants.restvoting.to;

import ru.restaurants.restvoting.model.MenuItem;

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

    public static MenuItemTo createFromMenuItem(MenuItem item) {
        MenuItemTo to = new MenuItemTo();
        to.setDescription(item.getDish().getDescription());
        to.setDate(item.getDate());
        to.setPrice(item.getPrice());
        if (item.getRestaurant() != null) {
            to.setRestaurantId(item.getRestaurant().getId());
        }
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItemTo)) return false;
        MenuItemTo that = (MenuItemTo) o;
        return description.equals(that.description) &&
                price.equals(that.price) &&
                date.equals(that.date) &&
                Objects.equals(restaurantId, that.restaurantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, date, restaurantId);
    }

    @Override
    public String toString() {
        return "MenuItemTo{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
