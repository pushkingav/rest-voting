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
import ru.restaurants.restvoting.to.MenuItemTo;
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
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void addDishes(List<MenuItemTo> dishesTos, Integer restaurantId) {
        //TODO - add cache!
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isEmpty()) {
            throw new NotFoundException("No restaurant found with id = " + restaurantId);
        }
        //TODO - this "select" MUST be cached!
        List<Dish> dishes = dishRepository.findAll();
        for (MenuItemTo menuItemTo : dishesTos) {
            Dish dish = dishes.stream().filter(d -> menuItemTo.getDescription().equals(d.getDescription())).findFirst().orElse(null);
            if (dish == null) {
                dish = create(DishUtil.createNewDishFromTo(menuItemTo));
            }
            MenuItem menuItem = DishUtil.createNewMenuItemFromTo(menuItemTo);
            menuItem.setDish(dish);
            menuItem.setRestaurant(restaurant.get());
            menuItemRepository.save(menuItem);
        }
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
}
