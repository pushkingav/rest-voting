package ru.restaurants.restvoting.to;

import ru.restaurants.restvoting.model.Restaurant;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class VotesCountTo extends BaseTo {
    @NotNull
    private Restaurant restaurant;

    @NotNull
    @Min(0L)
    private Long votesCount;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Long votesCount) {
        this.votesCount = votesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VotesCountTo)) return false;
        VotesCountTo that = (VotesCountTo) o;
        return restaurant.equals(that.restaurant) &&
                votesCount.equals(that.votesCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant, votesCount);
    }

    @Override
    public String toString() {
        return "VotesCountTo{" +
                "restaurant=" + restaurant +
                ", votesCount=" + votesCount +
                "} " + super.toString();
    }
}
