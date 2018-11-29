package org.lordofthejars.games.details.api;

import java.util.Optional;

public interface DetailService {
    Optional<Detail> findDetailByGameId(long gameId);
}
