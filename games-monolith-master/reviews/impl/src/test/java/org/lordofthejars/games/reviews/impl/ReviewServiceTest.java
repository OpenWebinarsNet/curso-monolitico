package org.lordofthejars.games.reviews.impl;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lordofthejars.games.reviews.api.Review;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {

    @Mock
    EntityManager entityManager;

    @Mock
    TypedQuery<Review> typedQuery;

    @Test
    public void should_find_reviews_by_id() {

        // given
        final Review review = new Review();
        when(entityManager.createNamedQuery("Review.FindReviewsByGameId", Review.class)).thenReturn(typedQuery);
        when(typedQuery.setParameter(anyString(), anyLong())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Arrays.asList(review));

        final ReviewServiceImpl reviewService = new ReviewServiceImpl();
        reviewService.entityManager = entityManager;

        // when
        final List<Review> reviewsByGameId = reviewService.findReviewsByGameId(1L);

        // then
        assertThat(reviewsByGameId)
            .hasSize(1);
    }

}
