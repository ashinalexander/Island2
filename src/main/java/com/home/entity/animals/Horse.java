package com.home.entity.animals;

import com.home.config.Config;

import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Animal {
    private static int indexHorse = 0;

    public Horse(boolean initFlag) {
        name = icon + ++indexHorse;
        if (initFlag) {
            factBreedingPeriod = ThreadLocalRandom.current().nextInt(breedingPeriod + 1);
            weight = ThreadLocalRandom.current().nextInt(Config.getWeight(entityType) + 1);
        }
        else {
            factBreedingPeriod = 0;
            weight = Config.getWeight(entityType);
        }

//        System.out.println("[Horse Horse()] " + entityType + " init:\n" +
//                "Icon:                 " + icon + "\n" +
//                "Name:                 " + getName() + "\n" +
//                "Weight:               " + weight + "\n" +
//                "Max food in animal:   " + maxFoodInAnimal + "\n" +
//                "Starving in step:     " + starvingInStep + "\n" +
//                "Breeding period:      " + breedingPeriod + "\n" +
//                "Fact Breeding period: " + factBreedingPeriod + "\n" +
//                "Ready to spawn:       " + isReadyToSpawn() + "\n" +
//                "Numbers of childs:    " + maxNumbersOfChilds + "\n" +
//                "Max move speed:       " + maxMoveSpeed + "\n");
    }

    @Override
    public String getName(){
        return name;
    }
}
