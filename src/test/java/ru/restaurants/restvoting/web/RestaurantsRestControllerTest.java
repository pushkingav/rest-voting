package ru.restaurants.restvoting.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.restaurants.restvoting.TestUtil;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.model.Role;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.web.json.JsonUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.restaurants.restvoting.TestUtil.userHttpBasic;
import static ru.restaurants.restvoting.model.AbstractBaseEntity.START_SEQ;
import static ru.restaurants.restvoting.web.RestaurantsRestController.RESTAURANTS_REST_URL;

//https://docs.spring.io/spring-restdocs/docs/1.0.0.M1/reference/html5/#getting-started-build-configuration-maven-plugin-phase
//https://opencredo.com/blogs/rest-api-tooling-review/
class RestaurantsRestControllerTest extends AbstractRestControllerTest {
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    @Test
    void addRestaurant() throws Exception {
        Restaurant created = new Restaurant("Test Restaurant Name");
        ResultActions actions = mockMvc.perform(post(RESTAURANTS_REST_URL)
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtil.writeValue(created))
                    .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());
        Restaurant returned = TestUtil.readFromJsonResultActions(actions, Restaurant.class);
        created.setId(returned.getId());
        assertThat(created).isEqualTo(returned);
        actions.andDo(document("add_restaurant", responseFields(
                        fieldWithPath("id").description("The id of the Restaurant"),
                        fieldWithPath("name").description("The Restaurant's name"))));
    }

    @Test
    void createMenuItems() {

    }

    @Test
    void getAllMenuItems() {
    }

    @Test
    void getAllRestaurants() throws Exception {
        this.mockMvc.perform(get(RESTAURANTS_REST_URL)
        .with(userHttpBasic(ADMIN)))
        .andExpect(status().isOk())
        /*TODO - changes in new version. This no longer works: .andDo(modifyResponseTo(ResponsePostProcessors.prettyPrintContent())*/
        .andDo(document("get_restaurants", responseFields(
                        fieldWithPath("[]id").description("The Restaurant's id"),
                        fieldWithPath("[]name").description("The Restaurant's name"))));
    }
}
