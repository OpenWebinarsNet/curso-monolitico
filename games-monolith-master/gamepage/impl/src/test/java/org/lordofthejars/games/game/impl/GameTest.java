package org.lordofthejars.games.game.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.arquillian.ape.junit.rule.ArquillianPersistenceRule;
import org.arquillian.ape.rdbms.core.RdbmsPopulator;
import org.arquillian.ape.rdbms.dbunit.DbUnit;
import org.arquillian.ape.rdbms.dbunit.DbUnitOptions;
import org.arquillian.ape.rdbms.flyway.Flyway;
import org.assertj.core.api.Assertions;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.lordofthejars.games.game.api.Game;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

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
                .schema("games")
                .build())
            .usingDataSets("game.yml")
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
    public void should_find_game_by_id() {
        final Game game = this.entityManager.find(Game.class, 1L);
        assertThat(game)
            .returns("The Secret Of Monkey Island", Game::getTitle)
            .returns("<p>It is a Point-and-Click adventure</p>", Game::getDescriptionHtml);
    }

}
