package ru.restaurants.restvoting.model;

public abstract class BaseEntity {
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
