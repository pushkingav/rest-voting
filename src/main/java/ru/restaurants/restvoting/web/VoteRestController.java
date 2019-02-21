package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurants.restvoting.service.UserService;
import ru.restaurants.restvoting.util.SecurityUtil;

import java.util.Map;

@ComponentScan
@RestController
@RequestMapping(value=VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/votes";

    @Autowired
    private UserService userService;

    @GetMapping("/today")
    public Map<Integer, Integer> getVotesForToday() {
        return userService.getVotesForToday();
    }

    @PostMapping("/{restaurant_id}")
    public void voteForRestaurant(@PathVariable("restaurant_id") Integer restaurantId) {
        int userId = SecurityUtil.authUserId();
        userService.vote(restaurantId, userId);
    }
}
