package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.repository.RestaurantRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Integer addRestaurant(String name) {
        return null;
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.getById(id);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.getAll();
    }

    @Override
    public Dish createDish(String name, BigDecimal price, int restaurantId) {
        return null;
    }

    @Override
    public boolean vote(User user, int restaurantId, LocalDateTime dateTime) {
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
