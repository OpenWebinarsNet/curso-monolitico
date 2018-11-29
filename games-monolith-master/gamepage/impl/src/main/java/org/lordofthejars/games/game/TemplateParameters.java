package org.lordofthejars.games.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.lordofthejars.games.details.api.Detail;
import org.lordofthejars.games.game.api.Game;
import org.lordofthejars.games.reviews.api.Review;

class TemplateParameters {

    static Map<String, Object> create(Game game, Detail detail, List<Review> reviews) {

        final Map<String, Object> templateData = new HashMap<>();
        templateData.put("game", game);
        templateData.put("detail", detail);
        templateData.put("reviews", reviews);

        return templateData;
    }

}
