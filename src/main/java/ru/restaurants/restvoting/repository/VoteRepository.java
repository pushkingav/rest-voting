package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteRepository {

    Vote saveOrUpdate(Vote vote, int userId);

    List<Vote> getAll();

    Vote getByUserAndDate(int userId, LocalDateTime localDateTime);

}
