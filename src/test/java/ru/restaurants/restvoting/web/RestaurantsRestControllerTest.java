package ru.restaurants.restvoting.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.restaurants.restvoting.TestUtil;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.web.json.JsonUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.restaurants.restvoting.TestData.*;
import static ru.restaurants.restvoting.TestUtil.userHttpBasic;
import static ru.restaurants.restvoting.web.RestaurantsRestController.RESTAURANTS_REST_URL;

//https://docs.spring.io/spring-restdocs/docs/1.0.0.M1/reference/html5/#getting-started-build-configuration-maven-plugin-phase
//https://opencredo.com/blogs/rest-api-tooling-review/
class RestaurantsRestControllerTest extends AbstractRestControllerTest {


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
    void createMenuItems() throws Exception {

    }
    //TODO - make this test to match MenuItemTOs instead of MenuItems. The equals method does not compare embedded dishes!
    @Test
    void getMenuOfRestaurant() throws Exception {
        mockMvc.perform(get(RESTAURANTS_REST_URL + "/100005/menu")
                            .with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(getMenuItemsToMatcher(MENU_ITEMS))
                .andDo(document("get_menu_items", responseFields(
                        fieldWithPath("[]id").description("Menu item id"),
                        fieldWithPath("[]date").description("Date when this menu is served"),
                        fieldWithPath("[]price").description("The price of the current menu item"),
                        fieldWithPath("[]dish.id").description("Dish id"),
                        fieldWithPath("[]dish.description").description("Dish description")
                )));
    }

    @Test
    void getAllRestaurants() throws Exception {
        this.mockMvc.perform(get(RESTAURANTS_REST_URL)
        .with(userHttpBasic(ADMIN)))
        .andExpect(status().isOk())
        .andDo(document("get_restaurants", responseFields(
                        fieldWithPath("[]id").description("The Restaurant's id"),
                        fieldWithPath("[]name").description("The Restaurant's name"))));
    }
}
