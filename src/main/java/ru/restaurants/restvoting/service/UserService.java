package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.to.VotesCountTo;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean vote(int restaurantId, int userId);

    List<VotesCountTo> listVotesCountToForToday();

    Map<Integer, Long> getMapOfVotesForToday();
}
