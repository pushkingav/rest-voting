package ru.restaurants.restvoting;

import org.springframework.test.web.servlet.ResultMatcher;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.model.Role;
import ru.restaurants.restvoting.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.restaurants.restvoting.TestUtil.convertMenuItemsToDtos;
import static ru.restaurants.restvoting.TestUtil.readListFromJsonMvcResult;
import static ru.restaurants.restvoting.model.AbstractBaseEntity.START_SEQ;

public class TestData {
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    private static final Dish dish1 = new Dish(START_SEQ + 8, "Овсянка");
    private static final Dish dish2 = new Dish(START_SEQ + 9, "Омлет");
    private static final Dish dish3 = new Dish(START_SEQ + 10, "Салатик");
    private static final Dish dish4 = new Dish(START_SEQ + 11, "Стейк");

    public static final MenuItem item1 = new MenuItem(START_SEQ + 16, LocalDate.now(), new BigDecimal(50), dish1);
    public static final MenuItem item2 = new MenuItem(START_SEQ + 18, LocalDate.now(), new BigDecimal(75), dish2);
    public static final MenuItem item3 = new MenuItem(START_SEQ + 19, LocalDate.now(), new BigDecimal(100), dish3);
    public static final MenuItem item4 = new MenuItem(START_SEQ + 20, LocalDate.now(), new BigDecimal(500), dish4);

    public static final List<MenuItem> MENU_ITEMS = List.of(item1, item2, item3, item4);

    public static void assertMatch(Iterable<MenuItem> actual, Iterable<MenuItem> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurantId").isEqualTo(expected);
    }

    public static ResultMatcher getMenuItemsToMatcher(List<MenuItem> expected) {
        return result -> assertThat(convertMenuItemsToDtos(readListFromJsonMvcResult(result, MenuItem.class))).isEqualTo(convertMenuItemsToDtos(expected));
    }

}
