package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.repository.MenuItemRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaMenuItemRepositoryImpl implements MenuItemRepository {
    @Autowired
    private CrudMenuItemRepository crudMenuItemRepository;

    @Override
    @Transactional
    public MenuItem save(MenuItem menuItem) {
        return crudMenuItemRepository.save(menuItem);
    }

    @Override
    public void deleteById(Integer id) {
        crudMenuItemRepository.deleteById(id);
    }

    @Override
    public MenuItem findById(Integer id) {
        return crudMenuItemRepository.findById(id).get();
    }

    @Override
    public List<MenuItem> findAll() {
        return crudMenuItemRepository.findAll();
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(Integer restaurantId) {
        return crudMenuItemRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public List<MenuItem> findAllByRestaurantIdAndDate(Integer restaurantId, LocalDate date) {
        return crudMenuItemRepository.findAllByRestaurantIdAndDate(restaurantId, date);
    }
}
