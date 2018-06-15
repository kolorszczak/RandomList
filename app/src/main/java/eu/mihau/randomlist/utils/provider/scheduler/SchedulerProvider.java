package eu.mihau.randomlist.utils.provider.scheduler;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler io();
    Scheduler ui();
    Scheduler computation();
}
