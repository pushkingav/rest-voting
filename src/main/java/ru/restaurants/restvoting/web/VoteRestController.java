package ru.restaurants.restvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.restaurants.restvoting.service.UserService;
import ru.restaurants.restvoting.util.SecurityUtil;

@ComponentScan
@RestController
@RequestMapping(value=VoteRestController.VOTES_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    public static final String VOTES_REST_URL = "/rest/votes";

    @Autowired
    private UserService userService;

    @PostMapping("/{restaurant_id}")
    public void voteForRestaurant(@PathVariable("restaurant_id") Integer restaurantId) {
        int userId = SecurityUtil.authUserId();
        userService.vote(restaurantId, userId);
    }
}
