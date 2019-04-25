package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.to.VotesCountTo;

import java.util.List;

public interface UserService {
    boolean vote(int restaurantId, int userId);

    /**
     *   Get all votes for custom date in a map like restaurantId -> votesTodayCount
     *
     * @return*/
    List<VotesCountTo> getVotesForToday();
}
