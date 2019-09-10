package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Vote;

import java.util.Map;

public interface UserService {
    Vote vote(int restaurantId, int userId);

    Map<Integer, Long> getMapOfVotesForToday();
}
