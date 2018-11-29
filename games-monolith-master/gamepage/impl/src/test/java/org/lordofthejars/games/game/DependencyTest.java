package org.lordofthejars.games.game;

import guru.nidi.codeassert.config.AnalyzerConfig;
import guru.nidi.codeassert.dependency.DependencyAnalyzer;
import guru.nidi.codeassert.dependency.DependencyResult;
import guru.nidi.codeassert.dependency.DependencyRule;
import guru.nidi.codeassert.dependency.DependencyRuler;
import guru.nidi.codeassert.dependency.DependencyRules;
import org.junit.Test;

import static guru.nidi.codeassert.junit.CodeAssertMatchers.hasNoCycles;
import static guru.nidi.codeassert.junit.CodeAssertMatchers.matchesRulesExactly;
import static org.junit.Assert.assertThat;

public class DependencyTest {

    // Analyze all sources in src/main/java
    private final AnalyzerConfig config = AnalyzerConfig.maven().main();

    @Test
    public void noCycles() {
        assertThat(new DependencyAnalyzer(config).analyze(), hasNoCycles());
    }

    @Test
    public void dependency() {
        class OrgLordofthejarsGames extends DependencyRuler {

            DependencyRule game, gameApi, gameImpl, detailsApi, reviewsApi;

            @Override
            public void defineRules() {
                game
                    .mustUse(gameApi, detailsApi, reviewsApi);

                gameImpl
                    .mayUse(game, gameApi);
            }
        }

        DependencyRules rules = DependencyRules.denyAll()
            .withRelativeRules(new OrgLordofthejarsGames())
            .withExternals("java.*", "javax.*", "freemarker.*",
                "io.reactivex",
                "io.reactivex.disposables",
                "io.reactivex.schedulers",
                "io.vavr.control",
                "io.github.resilience4j.circuitbreaker",
                "org.flywaydb.core");

        DependencyResult result = new DependencyAnalyzer(config)
            .rules(rules)
            .analyze();
        assertThat(result, matchesRulesExactly());
    }

}
