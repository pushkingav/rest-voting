package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.repository.RestaurantRepository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    CrudRestaurantRepository crudRestaurantRepository;

    @Override
    public Restaurant add(Restaurant restaurant) {
        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getById(Integer id) {
        return crudRestaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll();
    }

    @Override
    public Restaurant getByName(String name) {
        return crudRestaurantRepository.findByName(name).get();
    }
}
