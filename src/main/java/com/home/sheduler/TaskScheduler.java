package com.home.sheduler;

import com.home.areas.Island;
import com.home.areas.Area;
import com.home.config.Config;
import com.home.entity.animals.Animal;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskScheduler implements Runnable {
    private final Island island;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();


    public TaskScheduler(Island island) {
        this.island = island;
    }

    public void run() {
        boolean someoneHere = true;
        while (someoneHere) {
            someoneHere = false;
            for (int x = 0; x < Config.getSizeHorizontal(); x++) {
                for (int y = 0; y < Config.getSizeVertical(); y++) {
                    Area area = island.getAreaByCoordinatees(x, y);
                    if (area != null) {
                        area.getLock().lock();
                        try {
                            Set<String> items = new HashSet<>(area.getentities());
                            Animal animal;
                            for (String item : items) {
                                if (area.getItemByKey(item) instanceof Animal) {
                                    someoneHere = true;
                                    animal = (Animal) area.getItemByKey(item);
                                    animal.setActionComplite(false);
                                    animal.setCurrentMoveCount();
//                                    System.out.println("[TaskScheduler run() 39] " + animal.getName() + "CurrentMoveCount = " + animal.getCurrentMoveCount());
                                }
                            }
                        } finally {
                            area.getLock().unlock();
                        }
                    }
                }
            }
            for (int x = 0; x < Config.getSizeHorizontal(); x++) {
                for (int y = 0; y < Config.getSizeVertical(); y++) {
                    Area area = island.getAreaByCoordinatees(x, y);
                    if (area != null) {
                        area.getLock().lock();
                        try {
                            tasks.add(new Task(island, x, y));
                        } finally {
                            area.getLock().unlock();
                        }
                    }
                    tasks.forEach(Task::work);
                    tasks.clear();
                }

            }

            for (int x = 0; x < Config.getSizeHorizontal(); x++) {
                for (int y = 0; y < Config.getSizeVertical(); y++) {
                    Area area = island.getAreaByCoordinatees(x, y);
                    if (area != null) {
                        area.getLock().lock();
                        try {
                            Set<String> items = new HashSet<>(area.getentities());
                            Animal animal;
                            for (String item : items) {
                                if (area.getItemByKey(item) instanceof Animal) {
                                    animal = (Animal) area.getItemByKey(item);
                                    animal.incrementFactBreedingPeriod();
//                                    System.out.println("[TaskSheduler run() 77]:\n" + animal.toString());
                                }
                            }
                        } finally {
                            area.getLock().unlock();
                        }
                    }
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return;
    }
}



