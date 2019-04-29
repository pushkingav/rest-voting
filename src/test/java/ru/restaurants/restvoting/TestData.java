package ru.restaurants.restvoting;

import org.springframework.test.web.servlet.ResultMatcher;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.model.Role;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.to.MenuItemTo;
import ru.restaurants.restvoting.to.VotesCountTo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.restaurants.restvoting.TestUtil.convertMenuItemsToDtos;
import static ru.restaurants.restvoting.TestUtil.readListFromJsonMvcResult;
import static ru.restaurants.restvoting.model.AbstractBaseEntity.START_SEQ;

public class TestData {
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int TEST_RESTAURANT_ID = 100005;
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    private static final Dish dish1 = new Dish(START_SEQ + 8, "Овсянка");
    private static final Dish dish2 = new Dish(START_SEQ + 9, "Омлет");
    private static final Dish dish3 = new Dish(START_SEQ + 10, "Салатик");
    private static final Dish dish4 = new Dish(START_SEQ + 11, "Стейк");
    private static final Dish createdDish = new Dish(null, "Рубленая котлета");

    //Prices are given in kopecks/cents
    private static final MenuItem item1 = new MenuItem(START_SEQ + 16, LocalDate.now(), new BigDecimal(5000), dish1);
    private static final MenuItem item2 = new MenuItem(START_SEQ + 18, LocalDate.now(), new BigDecimal(7550), dish2);
    private static final MenuItem item3 = new MenuItem(START_SEQ + 19, LocalDate.now(), new BigDecimal(10000), dish3);
    private static final MenuItem item4 = new MenuItem(START_SEQ + 20, LocalDate.now(), new BigDecimal(50000), dish4);
    public static final MenuItem created = new MenuItem(null, LocalDate.now(), new BigDecimal(10000), createdDish);

    public static final List<MenuItem> MENU_ITEMS = List.of(item1, item2, item3, item4);

    public static void assertMatch(Iterable<MenuItemTo> actual, Iterable<MenuItemTo> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurantId").isEqualTo(expected);
    }

    public static ResultMatcher getMenuItemsToMatcher(List<MenuItem> expected) {
        return result -> assertMatch(convertMenuItemsToDtos(readListFromJsonMvcResult(result, MenuItem.class)),
                convertMenuItemsToDtos(expected));
    }

    public static ResultMatcher getVotesCountToMatcher(List<VotesCountTo> expected) {
        return result -> assertThat(readListFromJsonMvcResult(result, VotesCountTo.class)).isEqualTo(expected);
    }
}
