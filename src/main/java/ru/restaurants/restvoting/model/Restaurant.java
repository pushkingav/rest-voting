package ru.restaurants.restvoting.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurant extends AbstractBaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    protected List<Dish> dishes;

    public Restaurant(@NotBlank String name, List<Dish> dishes) {
        this.name = name;
        this.dishes = dishes;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                "} ";
    }
}
