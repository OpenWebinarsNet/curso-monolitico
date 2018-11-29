package org.lordofthejars.games.details.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
import org.lordofthejars.games.details.api.Detail;

import static org.assertj.core.api.Assertions.*;

public class DetailTest {

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
                .schema("details")
                .build())
            .usingDataSets("detail.yml")
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
    public void should_find_detail_by_id() {
        final Detail detail = this.entityManager.find(Detail.class, 1L);
        assertThat(detail)
            .returns("Ron Gilbert", Detail::getDirector)
            .returns("LucasArts", Detail::getPublisher);
    }
}