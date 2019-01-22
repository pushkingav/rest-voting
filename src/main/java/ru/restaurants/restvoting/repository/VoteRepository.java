package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {

    Vote saveOrUpdate(Vote vote, int userId);

    List<Vote> getAll();

    Integer countByDateAndRestaurantId(LocalDate date, int restaurantId);

    Vote getByUserIdAndDate(LocalDate date, int userId);
}
