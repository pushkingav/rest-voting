package ru.restaurants.restvoting.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dish extends BaseEntity {
    private Integer restaurant_id;
    private String name;
    private BigDecimal price;

    /**
     *  A date when this dish have been added to the menu
     *  */
    private LocalDateTime dateTime;

}
