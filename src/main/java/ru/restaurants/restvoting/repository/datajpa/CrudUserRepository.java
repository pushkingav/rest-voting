package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restaurants.restvoting.model.User;

public interface CrudUserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByEmail(String email);
}
