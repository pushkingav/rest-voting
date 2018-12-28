package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.model.Vote;
import ru.restaurants.restvoting.repository.VoteRepository;
import ru.restaurants.restvoting.util.LoggedUser;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaVoteRepositoryImpl implements VoteRepository {
    @Autowired
    CrudUserRepository crudUserRepository;

    @Autowired
    CrudVoteRepository crudVoteRepository;

    @Override
    public Vote saveOrUpdate(Vote vote, int userId) {
        User user = crudUserRepository.findById(LoggedUser.getLoggedUserId()).get();
        if (user != null) {
            vote.setUser(user);
        }
        return crudVoteRepository.save(vote);
    }

    @Override
    public List<Vote> getAll() {
        return crudVoteRepository.findAll();
    }

    @Override
    public Vote getByUserAndDate(int userId, LocalDateTime localDateTime) {
        User user = crudUserRepository.findById(LoggedUser.getLoggedUserId()).get();
        return crudVoteRepository.getByUserAndDateTime(user,localDateTime);
    }
}
