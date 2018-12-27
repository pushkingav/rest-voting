package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.User;

import java.util.List;

public interface UserRepository {
    User getById(Integer id);

    List<User> getAll();
}
