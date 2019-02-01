package ru.restaurants.restvoting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractBaseEntity {
    @Column(name = "description", nullable = false)
    @NotBlank
    protected String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    protected List<MenuItem> menuItems;

    public Dish() {
    }

    public Dish(Integer id, String description) {
        super(id);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dish{" + "id=" + id
                + " description='" + description
                + '}';
    }
}
