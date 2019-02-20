package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.AuthorizedUser;
import ru.restaurants.restvoting.model.AbstractBaseEntity;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.model.Vote;
import ru.restaurants.restvoting.repository.RestaurantRepository;
import ru.restaurants.restvoting.repository.UserRepository;
import ru.restaurants.restvoting.repository.VoteRepository;
import ru.restaurants.restvoting.util.exception.NotFoundException;
import ru.restaurants.restvoting.util.exception.TooLateForVoteException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VoteRepository voteRepository;

    @Value("#{T(java.time.LocalTime).parse('${last.voting.time}')}")
    private LocalTime lastVotingTime;

    @Override
    public Integer addRestaurant(String name) {
        return null;
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Integer id) {
        return restaurantRepository.getById(id);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.getAll();
    }

    @Override
    public boolean vote(int restaurantId, int userId) {
        //Remember to run this app with option "-Duser.timezone=GMT" - to force date operations be in UTC timezone
        LocalTime localTime = LocalTime.now();
        Optional<Restaurant> restaurantOptional = restaurantRepository.getById(restaurantId);
        if (restaurantOptional.isEmpty()) {
            throw new NotFoundException("No restaurant found with id " + restaurantId);
        }
        Vote vote = null;
        try {
            vote = voteRepository.getByUserIdAndDate(LocalDate.now(), userId);
        } catch (NoSuchElementException nse) {
            // No vote with such date and user - it's ok, we will create a new one!
            nse.printStackTrace();
        }
        if (vote == null) {
            vote = new Vote();
        } else {
            if (localTime.isAfter(lastVotingTime)) {
                throw new TooLateForVoteException("Your vote can't be changed after 11:00 UTC");
            }
        }
        vote.setDate(LocalDate.now());
        vote.setRestaurantId(restaurantId);
        return (voteRepository.saveOrUpdate(vote, userId)) != null;
    }

    @Override
    public Map<Integer, Integer> getVotesForDate(LocalDate date) {
        List<Integer> restaurant_ids = restaurantRepository.getAll()
                .stream().map(AbstractBaseEntity::getId).collect(Collectors.toList());
        Map<Integer, Integer> rawResult = new HashMap<>();
        restaurant_ids.forEach(r_id -> rawResult.put(r_id, voteRepository.countByDateAndRestaurantId(date, r_id)));
        //Sorting map by values (order by votes count desc)
        Map<Integer, Integer> result = rawResult.entrySet().stream().sorted(Map.Entry.comparingByValue((o2, o1) -> {
            if (o2 > o1) {
                return 1;
            } else {
                if (o2 < o1) {
                    return -1;
                }
            }
            return 0;
        }))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, HashMap::new)
                );
        return result;
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
