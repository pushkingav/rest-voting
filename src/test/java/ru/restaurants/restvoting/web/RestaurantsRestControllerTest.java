package ru.restaurants.restvoting.web;

import org.junit.jupiter.api.Test;
import org.springframework.restdocs.response.ResponsePostProcessors;
import ru.restaurants.restvoting.model.Role;
import ru.restaurants.restvoting.model.User;

import static org.springframework.restdocs.RestDocumentation.modifyResponseTo;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    void addRestaurant() {
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
        .andDo(modifyResponseTo(ResponsePostProcessors.prettyPrintContent())
                .andDocument("get_restaurants").withResponseFields(
                        fieldWithPath("[]id").description("The Restaurant's id"),
                        fieldWithPath("[]name").description("The Restaurant's name")));
    }
}