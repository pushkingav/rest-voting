package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restaurants.restvoting.model.Vote;

import java.time.LocalDate;

public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {
    Integer countByDateAndRestaurantId(LocalDate date, int restaurantId);
}
