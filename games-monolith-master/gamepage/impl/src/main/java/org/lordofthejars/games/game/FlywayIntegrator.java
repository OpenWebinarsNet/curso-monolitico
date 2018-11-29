package org.lordofthejars.games.game;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.lordofthejars.games.game.api.FlywayScripts;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class FlywayIntegrator {

    @Resource
    DataSource dataSource;

    @Inject
    @FlywayScripts({"db/migration", "db/foreign", "db/data"})
    Flyway flyway;

    @PostConstruct
    void migrateSchemas() {
        flyway.migrate();
    }

}
