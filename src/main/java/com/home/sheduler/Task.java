package com.home.sheduler;

import com.home.areas.Island;
import com.home.areas.Area;
import com.home.entity.BaseEntity;
import com.home.entity.animals.Animal;
import com.home.entity.animals.CanEat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Task {
    private final Island island;
    private final Area area;

    public Task(Island island, int x, int y) {
        this.island = island;
        this.area = island.getAreaByCoordinatees(x, y);
    }

    public void work() {
        Set<String> items = new HashSet<>(area.getentities());
        Animal animal;
        int actionChoise;
        for (String item : items) {
            if ((area.getItemByKey(item) instanceof Animal)
                    && (area.getItemByKey(item).isAlive())
                    && (!((Animal) area.getItemByKey(item)).isActionComplite())) {
                animal = (Animal) area.getItemByKey(item);
//                System.out.println("[Task work() 31:]");

//                    actionChoise = ThreadLocalRandom.current().nextInt(3);
                    actionChoise = 2;
                    switch (actionChoise) {
                        case 0 -> area.eatAnimals(animal);
                        case 1 -> island.moveAnimalsOnArea(area, animal);
                        case 2 -> area.reproduceAnimal(animal);
                    }

                animal.lostWeight();
                if (animal.getWeight() <= 0)
                    animal.die();
            }
        }
        Set<String> copyItems = new HashSet<>(area.getentities());
        for (String item : copyItems) {
            if (!area.getItemByKey(item).isAlive()) {
                area.comeOrAway(area.getItemByKey(item), false);
            }
        }
    }
}
