package com.home.entity.animals;

import com.home.config.Config;

import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Animal{
    private static int indexRabbit = 0;

    public Rabbit(boolean initFlag) {
        name = icon + ++indexRabbit;
        if (initFlag) {
            factBreedingPeriod = ThreadLocalRandom.current().nextInt(breedingPeriod + 1);
            weight = ThreadLocalRandom.current().nextInt(Config.getWeight(entityType) + 1);
        }
        else {
            factBreedingPeriod = 0;
            weight = Config.getWeight(entityType);
        }

//        System.out.println("[Rabbit Rabbit()] " + entityType + " init:\n" +
//                "Icon:                 " + icon + "\n" +
//                "Name:                 " + getName() + "\n" +
//                "Weight:               " + weight + "\n" +
//                "Max food in animal:   " + maxFoodInAnimal + "\n" +
//                "Starving in step:     " + starvingInStep + "\n" +
//                "Breeding period:      " + breedingPeriod + "\n" +
//                "Fact Breeding period: " + factBreedingPeriod + "\n" +
//                "Ready to spawn:        " + isReadyToSpawn() + "\n" +
//                "Numbers of childs:    " + maxNumbersOfChilds + "\n" +
//                "Max move speed:       " + maxMoveSpeed + "\n");
    }

    @Override
    public String getName(){
        return name;
    }
}
