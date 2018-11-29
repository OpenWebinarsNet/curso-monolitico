package org.lordofthejars.games.game;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import org.lordofthejars.games.details.api.Detail;
import org.lordofthejars.games.details.api.DetailService;
import org.lordofthejars.games.game.api.FreeMarker;
import org.lordofthejars.games.game.api.Game;
import org.lordofthejars.games.game.api.GameService;
import org.lordofthejars.games.reviews.api.Review;
import org.lordofthejars.games.reviews.api.ReviewService;

@Path("/")
public class GameResource {

    @Inject
    Scheduler scheduler;

    @Inject
    DetailService detailService;

    @Inject
    GameService gameService;

    @Inject
    ReviewService reviewService;

    @Inject
    @FreeMarker("gamepage.ftl")
    Template template;

    // The UI
    @GET
    @Path("{game}")
    @Produces(MediaType.TEXT_HTML)
    public void front(@Suspended final AsyncResponse asyncResponse, @PathParam("game") long gameId) throws IOException {

        Observable.zip(getGame(gameId)
                .subscribeOn(scheduler),
            getDetail(gameId)
                .subscribeOn(scheduler),
            getReviews(gameId)
                .subscribeOn(scheduler),
            (game, detail, reviews) -> TemplateParameters.create(game, detail, reviews))
            .subscribeOn(scheduler)
            .subscribe(renderTemplate(asyncResponse));

    }

    // The API
    @GET
    @Path("api/v1/games/{game}")
    @Produces(MediaType.APPLICATION_JSON)
    public void findGame(@Suspended final AsyncResponse asyncResponse, @PathParam("game") long gameId) {

        Observable.zip(getGame(gameId)
                .subscribeOn(scheduler),
            getDetail(gameId)
                .subscribeOn(scheduler),
            getReviews(gameId)
                .subscribeOn(scheduler),
            (game, detail, reviews) -> new GameInfo(game, detail, reviews))
        .subscribeOn(scheduler)
        .subscribe(sendGameInfo(asyncResponse));
    }

    private Observable<Game> getGame(final long gameId) {
        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext(gameService.findGameById(gameId).orElse(new Game()));
                e.onComplete();
            }
        });
    }

    private Observable<Detail> getDetail(final long gameId) {
        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext(detailService.findDetailByGameId(gameId).orElse(new Detail()));
                e.onComplete();
            }
        });
    }

    private Observable<List<Review>> getReviews(final long gameId) {
        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext(reviewService.findReviewsByGameId(gameId));
                e.onComplete();
            }
        });
    }

    private Observer<Map<String, Object>> renderTemplate(final AsyncResponse asyncResponse) {
        return new Observer<Map<String, Object>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Map<String, Object> templateData) {
                final StreamingOutput streamingOutput = (OutputStream out) -> {
                    final PrintWriter writer = new PrintWriter(out);
                    try {
                        template.process(templateData, writer);
                    } catch (TemplateException e) {
                        throw new IllegalArgumentException(e);
                    }
                };

                asyncResponse.resume(Response.ok(streamingOutput).build());
            }

            @Override
            public void onError(Throwable e) {
                asyncResponse.resume(e);
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private Observer<GameInfo> sendGameInfo(final AsyncResponse asyncResponse) {
        return new Observer<GameInfo>() {
            @Override
            public void onSubscribe(Disposable disposable) {
            }

            @Override
            public void onNext(GameInfo gameInfo) {
                asyncResponse.resume(Response.ok(gameInfo).build());
            }

            @Override
            public void onError(Throwable throwable) {
                asyncResponse.resume(throwable);
            }

            @Override
            public void onComplete() {
            }
        };
    }

}
