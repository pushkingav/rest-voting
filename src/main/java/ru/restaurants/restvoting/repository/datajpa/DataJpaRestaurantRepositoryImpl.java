package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    CrudRestaurantRepository crudRestaurantRepository;

    @Override
    @Transactional
    public Restaurant add(Restaurant restaurant) {
        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public Optional<Restaurant> getById(Integer id) {
        return crudRestaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll();
    }

    @Override
    public Restaurant getByName(String name) {
        Optional<Restaurant> optionalRestaurant = crudRestaurantRepository.findByName(name);
        return optionalRestaurant.orElse(null);
    }
}
