package org.lordofthejars.games.game.api;

import java.util.Optional;

public interface GameService {
    Optional<Game> findGameById(long gameId);
}
