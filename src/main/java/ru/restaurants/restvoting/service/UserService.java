package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserService {
    User create (User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByName(String name) throws NotFoundException;

    void update(User user);

    List<User> getAll();

    boolean vote(User user, int restaurantId, LocalDateTime dateTime);

    /**
    *   Get all votes for today in a map like restaurantId -> votesTodayCount
    * */
    Map<Integer, Integer> getTodayVotes();

    /**
     *   Get all votes for custom date in a map like restaurantId -> votesTodayCount
     * */
    Map<Integer, Integer> getVotesForDate(LocalDate date);
}
