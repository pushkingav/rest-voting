package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.repository.DishRepository;
import ru.restaurants.restvoting.repository.MenuItemRepository;
import ru.restaurants.restvoting.repository.RestaurantRepository;
import ru.restaurants.restvoting.to.DishTo;
import ru.restaurants.restvoting.util.DishUtil;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant, Integer id) {
        Optional<Restaurant> checked = restaurantRepository.findByName(restaurant.getName());
        if (checked.isEmpty()) {
            return null;
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem, int restaurantId) {
        return menuItem;
    }

    @Override
    @Transactional
    public void addDishes(List<DishTo> dishesTos, Integer restaurantId) {
        //TODO - add cache!
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isEmpty()) {
            throw new NotFoundException("No restaurant found with id = " + restaurantId);
        }
        //TODO - this "select" MUST be cached!
        List<Dish> dishes = dishRepository.findAll();
        for (DishTo dishTo: dishesTos) {
            Dish dish = dishes.stream().filter(d -> dishTo.getDescription().equals(d.getDescription())).findFirst().orElse(null);
            if (dish == null) {
                dish = create(DishUtil.createNewDishFromTo(dishTo));
            }
            MenuItem menuItem = DishUtil.createNewMenuItemFromTo(dishTo);
            menuItem.setDish(dish);
            menuItem.setRestaurant(restaurant.get());
            menuItemRepository.save(menuItem);
        }
    }

    @Override
    public Dish update(Dish dish, int restaurant_id) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish get(int id) throws NotFoundException {
        Optional<Dish> result = dishRepository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException("Not found Dish with id = " + id);
        }
        return result.get();
    }

    @Override
    public void delete(int id) throws NotFoundException {
        dishRepository.deleteById(id);
    }

    @Override
    public List<MenuItem> getAllByRestaurantId(int restaurantId) {
        return menuItemRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public List<MenuItem> getAllByRestaurantIdAndDate(int restaurantId, LocalDate date) {
        return menuItemRepository.findAllByRestaurantIdAndDate(restaurantId, date);
    }

    @Override
    public List<MenuItem> getAll() {
        return menuItemRepository.findAll();
    }



}
