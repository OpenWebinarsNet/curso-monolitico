package org.lordofthejars.games.game.impl;

import java.util.Optional;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lordofthejars.games.game.api.Game;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    EntityManager entityManager;

    @Test
    public void should_find_detail_by_id() {

        // given
        final Game game = new Game();
        when(entityManager.find(Game.class, 1L)).thenReturn(game);

        final GameServiceImpl gameService = new GameServiceImpl();
        gameService.entityManager = entityManager;

        // when
        final Optional<Game> gameById = gameService.findGameById(1L);

        // then
        assertThat(gameById)
            .isPresent();
    }

    @Test
    public void should_return_empty_detail_in_case_of_error() {

        // given
        when(entityManager.find(Game.class, 1L)).thenThrow(new RuntimeException());

        final GameServiceImpl gameService = new GameServiceImpl();
        gameService.entityManager = entityManager;

        // when
        final Optional<Game> gameById = gameService.findGameById(1L);

        // then
        assertThat(gameById)
            .isNotPresent();

    }

}
