package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.model.Vote;

import java.time.LocalDateTime;

public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {
    Vote getByUserAndDateTime(User user, LocalDateTime date);


}
