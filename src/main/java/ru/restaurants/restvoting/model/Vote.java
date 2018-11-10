package ru.restaurants.restvoting.model;

import java.time.LocalDateTime;

public class Vote extends BaseEntity {
    private Integer user_id;

    /**
     *  A date and time when this vote took place
     * */
    private LocalDateTime dateTime;

    private Integer restaurant_id;
}
