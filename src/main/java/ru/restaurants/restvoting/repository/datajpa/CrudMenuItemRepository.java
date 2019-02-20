package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.MenuItem;

import java.time.LocalDate;
import java.util.List;
//TODO - remove all CRUD repos and fix Spring context!
//Proxy!
@Transactional(readOnly = true)
public interface CrudMenuItemRepository extends JpaRepository<MenuItem, Integer> {
    @Override
    @Transactional
    MenuItem save(MenuItem menuItem);

    @Override
    //@Modifying - does not work here since no query provided
    @Transactional
    void deleteById(Integer id);

    @Override
    List<MenuItem> findAll();

    List<MenuItem> findAllByRestaurantId(Integer restaurantId);

    List<MenuItem> findAllByRestaurantIdAndDate(Integer restaurantId, LocalDate date);
}
