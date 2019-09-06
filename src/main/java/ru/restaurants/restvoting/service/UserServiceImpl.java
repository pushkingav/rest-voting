package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import ru.restaurants.restvoting.to.VotesCountTo;
import ru.restaurants.restvoting.util.exception.NotFoundException;
import ru.restaurants.restvoting.util.exception.TooLateForVoteException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public boolean vote(int restaurantId, int userId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        restaurantRepository.findById(restaurantId).orElseThrow(
                ()-> new NotFoundException("No restaurant found with id " + restaurantId)
        );
        Vote vote = voteRepository.getByUserIdAndDate(userId, LocalDate.now()).orElseThrow(
                () -> new TooLateForVoteException(String.format("Your vote can't be changed after %s", lastVotingTime.toString()))
        );
        vote.setDate(localDateTime.toLocalDate());
        vote.setRestaurantId(restaurantId);

        userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(String.format("No user found with id %s", userId))
        );
        return voteRepository.save(vote) != null;
    }

    @Override
    public List<VotesCountTo> listVotesCountToForToday() {
        List<Object[]> raw = voteRepository.getVotesForToday();
        List<Restaurant> restaurants = restaurantRepository.findAll();
        Map<Integer, Restaurant> map = restaurants.stream().collect(Collectors.toMap(Restaurant::getId, restaurant -> restaurant));
        List<VotesCountTo> result = new ArrayList<>();
        for (Object[] obj : raw) {
            VotesCountTo votesCountTo = new VotesCountTo();
            votesCountTo.setRestaurant(map.get(obj[0]));
            votesCountTo.setVotesCount((Long)obj[1]);
            result.add(votesCountTo);
        }
        return result;
    }

    @Override
    public Map<Integer, Long> getMapOfVotesForToday() {
        List<Object[]> raw = voteRepository.getVotesForToday();
        Map<Integer, Long> result = new HashMap<>();
        raw.forEach(objects -> result.put((Integer) objects[0], (Long) objects[1]));
        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
