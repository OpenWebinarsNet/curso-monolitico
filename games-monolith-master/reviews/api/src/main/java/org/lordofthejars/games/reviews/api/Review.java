package org.lordofthejars.games.reviews.api;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(schema = "reviews")
@NamedQuery(name = "Review.FindReviewsByGameId",
    query = "SELECT r FROM Review r WHERE r.gameId = :gameId")
public class Review {

    @Id
    private long id;

    @Column
    private String review;

    @Column
    private String reviewer;

    @Column
    @Min(value = 0, message = "Rating should not be less than 0")
    @Max(value = 5, message = "Rating should not be greater than 5")
    private int rating;

    @Column
    private long gameId;

    public Review() {
    }

    public Review(long id, String review, String reviewer, int rating, long gameId) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.gameId = gameId;
        this.reviewer = reviewer;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Review{");
        sb.append("id=").append(id);
        sb.append(", review='").append(review).append('\'');
        sb.append(", reviewer='").append(reviewer).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", gameId=").append(gameId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Review review1 = (Review) o;
        return id == review1.id &&
            rating == review1.rating &&
            gameId == review1.gameId &&
            Objects.equals(review, review1.review) &&
            Objects.equals(reviewer, review1.reviewer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, review, reviewer, rating, gameId);
    }
}
