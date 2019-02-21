package ru.restaurants.restvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restaurants.restvoting.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
