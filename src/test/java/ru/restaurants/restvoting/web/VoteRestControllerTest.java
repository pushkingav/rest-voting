package ru.restaurants.restvoting.web;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.restaurants.restvoting.TestData.ADMIN;
import static ru.restaurants.restvoting.TestData.TEST_RESTAURANT_ID;
import static ru.restaurants.restvoting.TestUtil.print;
import static ru.restaurants.restvoting.TestUtil.userHttpBasic;
import static ru.restaurants.restvoting.web.VoteRestController.VOTES_REST_URL;

class VoteRestControllerTest extends AbstractRestControllerTest {

    @Test
    void voteForRestaurant() throws Exception {
        mockMvc.perform(post(VOTES_REST_URL + "/" + TEST_RESTAURANT_ID)
        .with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getVotesForToday() throws Exception {
        ResultActions actions =
        mockMvc.perform(get(VOTES_REST_URL).with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful());
        print(actions);
    }
}
