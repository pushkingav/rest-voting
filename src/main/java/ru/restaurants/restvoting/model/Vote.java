package ru.restaurants.restvoting.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {
    /**
     *  A date and time when this vote took place
     * */
    @Column(name="date", nullable = false)
    private @NotNull LocalDate date;

    @Column(name="restaurant_id", nullable = false)
    @NotNull
    private Integer restaurantId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Vote(@NotNull LocalDate date, @NotNull Integer restaurantId, @NotNull User user) {
        this.date = date;
        this.restaurantId = restaurantId;
        this.user = user;
    }

    public Vote() {
    }

    public @NotNull LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull LocalDate dateTime) {
        this.date = dateTime;
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
                ", dateTime=" + date +
                '}';
    }
}
