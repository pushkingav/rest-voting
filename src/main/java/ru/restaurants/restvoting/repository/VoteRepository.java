package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Vote;

public interface VoteRepository {
    Vote save(Vote vote);

    Vote update(Vote vote);

}
