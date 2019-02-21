package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.model.Vote;
import ru.restaurants.restvoting.repository.UserRepository;
import ru.restaurants.restvoting.repository.VoteRepository;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class DataJpaVoteRepositoryImpl implements VoteRepository {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CrudVoteRepository crudVoteRepository;

    @Override
    public Vote saveOrUpdate(Vote vote, int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            vote.setUser(user.get());
        } else {
            throw new NotFoundException(String.format("No user found with id %s", userId));
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
