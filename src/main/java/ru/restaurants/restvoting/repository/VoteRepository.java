package ru.restaurants.restvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @Override
    @Transactional
    Vote save(Vote vote);

    @Transactional
    @Query("select v.restaurantId, count(all v) from Vote v group by v.restaurantId")
    List<Object[]> getVotesForToday();

    Optional<Vote> getByUserIdAndDate(int userId, LocalDate date);
}
