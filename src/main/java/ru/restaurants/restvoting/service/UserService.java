package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.to.VotesCountTo;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean vote(int restaurantId, int userId);

    /**
     *   Get all votes for today date in a map like restaurantId -> votesTodayCount
     *
     * @return*/
    List<VotesCountTo> listVotesCountToForToday();

    /**
     *   Get all votes for today date in a map like restaurantId -> votesTodayCount
     */
    Map<Integer, Long> getMapOfVotesForToday();
}
