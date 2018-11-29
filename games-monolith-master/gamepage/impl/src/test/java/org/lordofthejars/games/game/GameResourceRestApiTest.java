package org.lordofthejars.games.game;

import io.restassured.builder.RequestSpecBuilder;
import java.net.URISyntaxException;
import java.net.URL;
import org.arquillian.container.chameleon.api.ChameleonTarget;
import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.arquillian.container.chameleon.runner.ArquillianChameleon;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@RunWith(ArquillianChameleon.class)
@ChameleonTarget("wildfly:11.0.0.Final:managed")
@MavenBuild(pom = "../../pom.xml", module = "gamepage/impl")
@DeploymentParameters(testable = false)
public class GameResourceRestApiTest {

    @ArquillianResource
    URL url;

    @Test
    public void should_call_template_engine_to_generate_html_output() throws URISyntaxException {
        final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url.toURI());
        requestSpecBuilder.setBasePath("api/v1");

        given(requestSpecBuilder.build())
            .get("/games/{game}", 1)
            .then()
            .body("game.title", is("The Secret Of Monkey Island"))
            .body("detail.director", is("Ron Gilbert"));
    }
}
