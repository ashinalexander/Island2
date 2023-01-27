package com.home.sheduler;

import com.home.areas.Island;

public class StatisticTask implements Runnable{
    private final Island island;

    public StatisticTask(Island island){
        this.island = island;
    }
    @Override
    public void run() {
        System.out.println("\n");
        island.print();
    }

}
