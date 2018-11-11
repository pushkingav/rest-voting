package ru.restaurants.restvoting.service;

import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByName(String name) throws NotFoundException {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean vote(User user, int restaurantId) {
        return false;
    }

    @Override
    public Map<Integer, Integer> getTodayVotes() {
        return null;
    }

    @Override
    public Map<Integer, Integer> getVotesForDate(LocalDate date) {
        return null;
    }
}
