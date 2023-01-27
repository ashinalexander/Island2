package com.home.entity.animals;

import com.home.config.Config;
import com.home.entity.BaseEntity;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends BaseEntity implements CanEat, Spawn, CanMove {

    protected int breedingPeriod;
    protected int factBreedingPeriod;


    protected int maxMoveSpeed;
    protected int currentMoveCount;

    protected int maxFoodInAnimal;
    protected int starvingInStep;

    protected int maxNumbersOfChilds;

    public boolean isMoveFinished() {
//        System.out.println("Animal isMoveFinished() : currentMoveCount == " + currentMoveCount);
        if (currentMoveCount <= 0)
            return true;
        return false;
    }

    protected boolean actionComplite = false;

    public boolean isActionComplite() {
        return actionComplite;
    }

    public void setActionComplite(boolean actionComplite) {
        this.actionComplite = actionComplite;
    }


    public int getCurrentMoveCount() {
        return currentMoveCount;
    }

    public void decrementCurrentMoveCount() {
        this.currentMoveCount--;
    }

    public void setCurrentMoveCount() {
        if (this.maxMoveSpeed > 0)
            this.currentMoveCount = ThreadLocalRandom.current().nextInt(1, this.maxMoveSpeed + 1);
        else this.currentMoveCount = 0;
    }

    public void restartFactBreedingPeriod() {
        this.factBreedingPeriod = 0;
    }

    public void incrementFactBreedingPeriod() {
        this.factBreedingPeriod++;
    }

    public boolean isReadyToSpawn() {
        if (this.factBreedingPeriod >= this.breedingPeriod)
            return true;
        return false;
    }

    @Override
    public boolean spawn(Animal animal) {
        this.factBreedingPeriod = 0;
        animal.restartFactBreedingPeriod();
        return true;
    }

    @Override
    public void eat(int howMany, String animal) {
//        System.out.println("[Animal eat()] Preys howMani : " + howMany + "\n" +
//                "Hunter max food : " + maxFoodInAnimal + "\n" +
//                "Hunter weight before eating: " + weight);
        System.out.println();
        if (howMany < maxFoodInAnimal)
            weight += howMany;
        else
            weight += maxFoodInAnimal;
        if ((weight + howMany) > Config.getWeight(entityType)) {
            weight = Config.getWeight(entityType);
        }
//        System.out.println("[Animal eat()] Hunter weight after eating: " + weight);
    }

    @Override
    public void move() {
    }


    public int getMaxNumbersOfChilds() {
        return maxNumbersOfChilds;
    }

    public void lostWeight() {
        weight -= starvingInStep;
    }


    public int getMaxMoveSpeed() {
        return maxMoveSpeed;
    }

    public Animal() {
        maxFoodInAnimal = Config.getMaxFoodInAnimals().get(entityType);
        starvingInStep = Config.getStarvingsInStep().get(entityType);
        breedingPeriod = Config.getBreedingPeriod(entityType);
        maxMoveSpeed = Config.getMaxMoveSpeeds().get(entityType);
        maxNumbersOfChilds = Config.getMaxNumberOfChilds(entityType);
    }

    @Override
    public String toString() {
        return "[Animal toString()] " + entityType + " : \n" +
                "Name:                 " + getName() + "\n" +
                "Weight:               " + weight + "\n" +
                "Max food in animal:   " + maxFoodInAnimal + "\n" +
                "Starving in step:     " + starvingInStep + "\n" +
                "Breeding period:      " + breedingPeriod + "\n" +
                "Fact Breeding period: " + factBreedingPeriod + "\n" +
                "Ready to spawn:       " + isReadyToSpawn() + "\n" +
                "Numbers of childs:    " + maxNumbersOfChilds + "\n" +
                "Max move speed:       " + maxMoveSpeed + "\n" +
                "Cur. Breeding period: " + factBreedingPeriod + "\n" +
                "Is Alive:             " + isAlive;
    }
}
