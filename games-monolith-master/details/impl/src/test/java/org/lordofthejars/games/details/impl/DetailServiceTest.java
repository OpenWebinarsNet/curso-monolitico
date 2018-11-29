package org.lordofthejars.games.details.impl;

import java.util.Optional;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lordofthejars.games.details.api.Detail;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailServiceTest {

    @Mock
    EntityManager entityManager;

    @Test
    public void should_find_detail_by_id() {

        // given
        final Detail detail = new Detail();
        when(entityManager.find(Detail.class, 1L)).thenReturn(detail);

        final DetailServiceImpl detailService = new DetailServiceImpl();
        detailService.entityManager = entityManager;

        // when
        final Optional<Detail> detailByGameId = detailService.findDetailByGameId(1L);

        // then
        assertThat(detailByGameId)
            .isPresent();
    }

    @Test
    public void should_return_empty_detail_in_case_of_error() {

        // given
        when(entityManager.find(Detail.class, 1L)).thenThrow(new RuntimeException());

        final DetailServiceImpl detailService = new DetailServiceImpl();
        detailService.entityManager = entityManager;

        // when
        final Optional<Detail> detailByGameId = detailService.findDetailByGameId(1L);

        // then
        assertThat(detailByGameId)
            .isNotPresent();

    }

}
