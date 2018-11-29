package org.lordofthejars.games.reviews.api;

import java.util.List;

public interface ReviewService {

    List<Review> findReviewsByGameId(long gameId);

}
