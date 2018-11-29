package org.lordofthejars.games.reviews.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.arquillian.ape.junit.rule.ArquillianPersistenceRule;
import org.arquillian.ape.rdbms.core.RdbmsPopulator;
import org.arquillian.ape.rdbms.dbunit.DbUnit;
import org.arquillian.ape.rdbms.dbunit.DbUnitOptions;
import org.arquillian.ape.rdbms.flyway.Flyway;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.lordofthejars.games.reviews.api.Review;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewTest {

    @Rule
    public ArquillianPersistenceRule arquillianPersistenceRule = new ArquillianPersistenceRule();

    @DbUnit
    @ArquillianResource
    RdbmsPopulator dbunit;

    @Flyway
    @ArquillianResource
    RdbmsPopulator flyway;

    EntityManager entityManager;

    @Before
    public void prepareEntityManager() {

        // generate schema
        flyway.project()
            .fromJpaPersistence()
            .usingDataSet("db/migration")
            .execute();

        this.entityManager = Persistence.createEntityManagerFactory("integration-test").createEntityManager();

        // populate data
        dbunit.project()
            .fromJpaPersistence()
            .withOptions(DbUnitOptions.options()
                .schema("reviews")
                .build())
            .usingDataSets("review.yml")
            .execute();
    }

    @After
    public void removeData() {
        flyway.project()
            .fromJpaPersistence()
            .usingDataSet("db/migration")
            .clean();
    }

    @Test
    public void should_find_review_by_id() {
        final Review review = this.entityManager.find(Review.class, 1L);
        assertThat(review)
            .returns("This game is better than previous one", Review::getReview)
            .returns("Alex", Review::getReviewer)
            .returns(4, Review::getRating);
    }

}
