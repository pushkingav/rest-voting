package ru.restaurants.restvoting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "menu")
public class MenuItem extends AbstractBaseEntity {
    /**
     *  A date when this dish have been added to the menu
     *  */
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "price", nullable = false)
    @NotNull
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    @JsonIgnore
    protected Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id", nullable = false)
    @NotNull
    protected Dish dish;

    public MenuItem() {
    }

    public MenuItem(Integer id, BigDecimal price, LocalDate date) {
        super(id);
        this.price = price;
        this.date = date;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id +
                ", price=" + price +
                ", date=" + date + '}';
    }
}
