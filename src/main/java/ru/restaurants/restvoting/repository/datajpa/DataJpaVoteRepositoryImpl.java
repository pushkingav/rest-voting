package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.model.Vote;
import ru.restaurants.restvoting.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaVoteRepositoryImpl implements VoteRepository {
    @Autowired
    CrudUserRepository crudUserRepository;

    @Autowired
    CrudVoteRepository crudVoteRepository;

    @Override
    public Vote saveOrUpdate(Vote vote, int userId) {
        User user = crudUserRepository.findById(userId).get();
        if (user != null) {
            vote.setUser(user);
        }

        return crudVoteRepository.save(vote);
    }

    @Override
    public List<Vote> getAll() {
        return crudVoteRepository.findAll();
    }

    public Integer countByDateAndRestaurantId(LocalDate date, int restaurantId) {
        return crudVoteRepository.countByDateAndRestaurantId(date, restaurantId);
    }

    @Override
    public Vote getByUserIdAndDate(LocalDate date, int userId) {
        return crudVoteRepository.getByDateAndUserId(date, userId);
    }
}
