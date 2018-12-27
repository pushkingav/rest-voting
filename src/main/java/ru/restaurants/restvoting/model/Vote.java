package ru.restaurants.restvoting.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {
    /**
     *  A date and time when this vote took place
     * */
    @Column(name="date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(name="restaurant_id", nullable = false)
    @NotNull
    private Integer restaurantId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Vote(@NotNull LocalDateTime dateTime, @NotNull Integer restaurantId, @NotNull User user) {
        this.dateTime = dateTime;
        this.restaurantId = restaurantId;
        this.user = user;
    }

    public Vote() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "userId=" + user.getId() +
                ", restaurantId=" + restaurantId +
                ", dateTime=" + dateTime +
                '}';
    }
}
