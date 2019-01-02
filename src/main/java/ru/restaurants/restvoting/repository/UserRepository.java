package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.User;

import java.util.List;

public interface UserRepository {
    User getById(Integer id);

    User getByName(String name);

    User getByEmail(String email);

    List<User> getAll();
}