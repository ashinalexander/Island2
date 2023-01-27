package com.home.sheduler;

import com.home.areas.Island;
import com.home.config.Config;

public class PlantTask implements Runnable {
    private final Island island;

    public PlantTask(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (int x = 0; x < Config.getSizeHorizontal(); x++)
            for (int y = 0; y < Config.getSizeVertical(); y++)
                island.getAreaByCoordinatees(x, y).plantGrass();
    }
}
