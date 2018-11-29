package org.lordofthejars.games.details.impl;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.lordofthejars.games.details.api.Detail;
import org.lordofthejars.games.details.api.DetailService;

@ApplicationScoped
@Transactional
class DetailServiceImpl implements DetailService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Detail> findDetailByGameId(long gameId) {

        final CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("database");

        CheckedFunction0<Optional<Detail>> checkedSupplier = CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> {
            final Detail detail =
                entityManager.find(Detail.class, gameId);
            return Optional.ofNullable(detail);
        });

        // TODO log exception
        Try<Optional<Detail>> result = Try.of(checkedSupplier)
            .recover(throwable -> Optional.empty());

        return result.get();
    }
}
