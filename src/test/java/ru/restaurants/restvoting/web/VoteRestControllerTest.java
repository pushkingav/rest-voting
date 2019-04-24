package ru.restaurants.restvoting.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.ResultActions;
import ru.restaurants.restvoting.service.UserService;

import java.time.LocalTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.restaurants.restvoting.TestData.ADMIN;
import static ru.restaurants.restvoting.TestData.TEST_RESTAURANT_ID;
import static ru.restaurants.restvoting.TestUtil.print;
import static ru.restaurants.restvoting.TestUtil.userHttpBasic;
import static ru.restaurants.restvoting.web.VoteRestController.VOTES_REST_URL;

class VoteRestControllerTest extends AbstractRestControllerTest {
    @Value("#{T(java.time.LocalTime).parse('${last.voting.time}')}")
    private LocalTime lastVotingTime;

    @Autowired
    UserService userService;

    @Test
    void voteForRestaurant() throws Exception {
        LocalTime currentTime = LocalTime.now();
        //if we can't vote today since the time is up the test will exit
        if (currentTime.isAfter(lastVotingTime)) {
            return;
        }
        Map<Integer, Long> oldVotesForToday = userService.getVotesForToday();
        assertThat(oldVotesForToday.get(TEST_RESTAURANT_ID)).isEqualTo(2L);
        assertThat(oldVotesForToday.get(TEST_RESTAURANT_ID + 1)).isEqualTo(1L);

        //Re-voting via ADMIN's credentials from the restaurant 100005 to the restaurant 100006
        mockMvc.perform(post("/rest/votes/{restaurant_id}", TEST_RESTAURANT_ID + 1)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful())
                .andDo(document("vote_for_restaurant", pathParameters(
                        parameterWithName("restaurant_id").description("The Restaurant's id we are voting for")
        )));

        Map<Integer, Long> newVotesForToday = userService.getVotesForToday();
        assertThat(newVotesForToday.get(TEST_RESTAURANT_ID)).isEqualTo(1L);
        assertThat(newVotesForToday.get(TEST_RESTAURANT_ID + 1)).isEqualTo(2L);


    }

    @Test
    void getVotesForToday() throws Exception {
        ResultActions actions =
                mockMvc.perform(get(VOTES_REST_URL).with(userHttpBasic(ADMIN)))
                        .andExpect(status().is2xxSuccessful());
        print(actions);
    }

    @Test
    void testVoteFailAfterStopHour() throws Exception {

    }
}
