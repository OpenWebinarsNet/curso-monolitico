package org.lordofthejars.games.game.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.IOException;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.lordofthejars.games.game.GameResource;
import org.lordofthejars.games.game.api.FreeMarker;

class TemplateProducer {

    @Produces @FreeMarker("")
    Template buildTemplateProcessor(InjectionPoint injectionPoint) throws IOException {

        final Configuration cfg = new Configuration(new Version(2, 3, 23));

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(GameResource.class, "/");

        // Some other recommended settings:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        return cfg.getTemplate(injectionPoint.getAnnotated().getAnnotation(FreeMarker.class).value());
    }

}
