package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.repository.UserRepository;

import java.util.List;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {
    @Autowired
    CrudUserRepository crudUserRepository;

    @Override
    public User getById(Integer id) {
        //TODO - change to properly work with Optional
        return crudUserRepository.findById(id).get();
    }

    @Override
    public User getByName(String name) {
        return crudUserRepository.findByName(name);
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll();
    }
}
