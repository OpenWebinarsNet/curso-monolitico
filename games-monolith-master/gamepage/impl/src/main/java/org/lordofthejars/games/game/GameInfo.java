package org.lordofthejars.games.game;

import java.util.List;
import org.lordofthejars.games.details.api.Detail;
import org.lordofthejars.games.game.api.Game;
import org.lordofthejars.games.reviews.api.Review;

class GameInfo {

    private Game game;
    private Detail detail;
    private List<Review> reviews;

    public GameInfo(Game game, Detail detail, List<Review> reviews) {
        this.game = game;
        this.detail = detail;
        this.reviews = reviews;
    }

    public Game getGame() {
        return game;
    }

    public Detail getDetail() {
        return detail;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public double getAverage() {
        return reviews
            .stream()
            .mapToInt(Review::getRating)
            .average()
            .getAsDouble();
    }

}
