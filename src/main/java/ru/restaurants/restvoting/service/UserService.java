package ru.restaurants.restvoting.service;

import java.util.Map;

public interface UserService {
    boolean vote(int restaurantId, int userId);

    /**
     *   Get all votes for custom date in a map like restaurantId -> votesTodayCount
     * */
    Map<Integer, Long> getVotesForToday();
}
