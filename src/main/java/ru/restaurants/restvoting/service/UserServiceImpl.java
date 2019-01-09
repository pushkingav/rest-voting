package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.AuthorizedUser;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.model.Vote;
import ru.restaurants.restvoting.repository.RestaurantRepository;
import ru.restaurants.restvoting.repository.UserRepository;
import ru.restaurants.restvoting.repository.VoteRepository;
import ru.restaurants.restvoting.util.LoggedUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VoteRepository voteRepository;

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
    public boolean vote(int restaurantId) {
        //Remember to run this app with option "-Duser.timezone=GMT" - to force date operations be in UTC timezone
        LocalDateTime localDateTime = LocalDateTime.now();

        if (localDateTime.getHour() >= 11) {
            return false;
        }
        Vote vote = new Vote();
        vote.setDateTime(localDateTime);
        vote.setRestaurantId(restaurantId);

        return (voteRepository.saveOrUpdate(vote, LoggedUser.getLoggedUserId())) != null;
    }

    @Override
    public Map<Integer, Integer> getTodayVotes() {
        return null;
    }

    @Override
    public Map<Integer, Integer> getVotesForDate(LocalDate date) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
