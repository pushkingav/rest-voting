package ru.restaurants.restvoting.model;

import java.time.LocalDateTime;

public class Vote extends AbstractBaseEntity {
    private Integer userId;

    /**
     *  A date and time when this vote took place
     * */
    private LocalDateTime dateTime;

    private Integer restaurantId;
}
