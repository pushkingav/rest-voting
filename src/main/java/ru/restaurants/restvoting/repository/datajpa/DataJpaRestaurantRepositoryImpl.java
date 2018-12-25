package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.repository.RestaurantRepository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    CrudRestaurantRepository restaurantRepository;

    @Override
    public void add(Restaurant restaurant) {
        //TODO - add something!
    }

    @Override
    public Restaurant getById(Integer id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }
}
