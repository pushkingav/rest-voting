package ru.restaurants.restvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Vote;

import java.time.LocalDate;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @Override
    @Transactional
    Vote save(Vote vote);

    Integer countByDateAndRestaurantId(LocalDate date, int restaurantId);

    Optional<Vote> getByUserIdAndDate(int userId, LocalDate date);
}
