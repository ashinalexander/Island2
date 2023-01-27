package com.home;

import com.home.areas.Island;
import com.home.sheduler.PlantTask;
import com.home.sheduler.StatisticTask;
import com.home.sheduler.TaskScheduler;

import java.util.concurrent.*;
public class Executor {
    public void execute(Island island) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new PlantTask(island), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new StatisticTask(island), 0, 2, TimeUnit.SECONDS);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.submit(new TaskScheduler(island));
//        executorService.shutdownNow();

    }
}
