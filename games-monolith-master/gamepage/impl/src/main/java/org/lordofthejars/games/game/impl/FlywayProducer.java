package org.lordofthejars.games.game.impl;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.lordofthejars.games.game.api.FlywayScripts;

public class FlywayProducer {

    @Resource
    DataSource dataSource;

    @Produces
    @FlywayScripts("")
    Flyway buildFlyway(InjectionPoint injectionPoint) {

        if (dataSource == null) {
            throw new IllegalStateException("No DataSource found to execute Flyway Database Migrations");
        }

        final Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        //flyway.setLocations("db/migration", "db/foreign", "db/data");
        flyway.setLocations(injectionPoint.getAnnotated().getAnnotation(FlywayScripts.class).value());

        return flyway;
    }


}
