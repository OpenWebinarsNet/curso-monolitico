package org.lordofthejars.games.reviews.impl;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.lordofthejars.games.reviews.api.Review;
import org.lordofthejars.games.reviews.api.ReviewService;

@ApplicationScoped
@Transactional
class ReviewServiceImpl implements ReviewService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Review> findReviewsByGameId(long gameId) {
        return entityManager.createNamedQuery("Review.FindReviewsByGameId", Review.class)
            .setParameter("gameId", gameId)
            .getResultList();
    }
}
