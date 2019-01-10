package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {

    Vote saveOrUpdate(Vote vote, int userId);

    List<Vote> getAll();

    Integer countByDateTimeAndRestaurantId(LocalDate date, int restaurantId);

    //select count(USER_ID) from Votes where date_time is ...

}
