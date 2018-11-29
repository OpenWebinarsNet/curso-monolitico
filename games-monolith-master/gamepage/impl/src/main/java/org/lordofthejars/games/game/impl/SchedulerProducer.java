package org.lordofthejars.games.game.impl;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Produces;

class SchedulerProducer {


    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;

    @Produces
    Scheduler createScheduler() {
        return Schedulers.from(executor);
    }
}
