package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.repository.DishRepository;
import ru.restaurants.restvoting.repository.RestaurantRepository;
import ru.restaurants.restvoting.repository.VoteRepository;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private VoteRepository voteRepository;

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.dishRepository = repository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant, Integer id) {
        Restaurant checked = restaurantRepository.getByName(restaurant.getName());
        if (checked != null) {
            return null;
        }
        return restaurantRepository.add(restaurant);
    }

    @Override
    public List<Restaurant> listAllRestaurants() {
        return restaurantRepository.getAll();
    }

    @Override
    public Dish create(Dish dish, int restaurant_id) {
        return dishRepository.save(dish, restaurant_id);
    }

    @Override
    public void addDishes(List<Dish> dishes, Integer restaurantId) {
        //TODO - add logic for handling wrong restaurantIds
        dishes.forEach(dish -> dishRepository.save(dish, restaurantId));
    }

    @Override
    public Dish update(Dish dish, int restaurant_id) {
        return dishRepository.save(dish, restaurant_id);
    }

    @Override
    public Dish get(int id) throws NotFoundException {
        Dish result = dishRepository.findById(id);
        if (result == null) {
            throw new NotFoundException("Not found Dish with id = " + id);
        }
        return result;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> getAllByRestaurantId(int restaurantId) {
        return dishRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public List<Dish> getAllByRestaurantIdAndDate(int restaurantId, LocalDate date) {
        return dishRepository.findAllByRestaurantIdAndDate(restaurantId, date);
    }

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }



}
