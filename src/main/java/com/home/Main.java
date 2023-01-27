package com.home;

import com.home.areas.Island;
import com.home.config.Config;
import com.home.entity.animals.Wolf;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
//        System.out.println("getSizeHorizontal() " + Config.getSizeHorizontal());
//        System.out.println("getSizeVertical() " + Config.getSizeVertical());
//        System.out.println("getStopOptions() " + Config.getStopOptions());
//        System.out.println("getFinalStep() " + Config.getFinalStep());
//        System.out.println("getAreaNamePrefix() " + Config.getAreaNamePrefix());
//        System.out.println("getWolf() " + Config.getWolfDiet());
//        System.out.println("getBoa() " + Config.getBoaDiet());
//        System.out.println("getFox() " + Config.getFoxDiet());
//        System.out.println("getBear() " + Config.getBearDiet());
//        System.out.println("getEagle() " + Config.getEagleDiet());
//        System.out.println("getHorse() " + Config.getHorseDiet());
//        System.out.println("getDeer() " + Config.getDeerDiet());
//        System.out.println("getRabbit() " + Config.getRabbitDiet());
//        System.out.println("getMouse() " + Config.getMouseDiet());
//        System.out.println("getGoat() " + Config.getGoatDiet());
//        System.out.println("getSheep() " + Config.getSheepDiet());
//        System.out.println("getBoar() " + Config.getBoarDiet());
//        System.out.println("getBuffalo() " + Config.getBuffaloDiet());
//        System.out.println("getDuck() " + Config.getDuckDiet());
//        System.out.println("getCaterpillar() " + Config.getCaterpillarDiet());
//        System.out.println("getIcons() " + Config.getIcons());
//        System.out.println("getWeights() " + Config.getWeights());
//        System.out.println("getMaxCountEntitiesInArea() " + Config.getMaxCountEntitiesInArea());
//        System.out.println("getCountEntitiesInAreaOnInit() " + Config.getCountEntitiesInAreaOnInit());
//        System.out.println("getMaxMoveSpeeds() " + Config.getMaxMoveSpeeds());
//        System.out.println("getMaxFoodInAnimals() " + Config.getMaxFoodInAnimals());
//        System.out.println("getBreedingPeriods() " + Config.getBreedingPeriods());
//        System.out.println("getStarvingsInStep() " + Config.getStarvingsInStep());
//        String[] hunter1 = "Wolf/Boa/Fox/Bear/Eagle/Horse/Deer/Rabbit/Mouse/Goat/Sheep/Boar/Buffalo/Duck/Caterpillar/Plant".split("/");
//        for (String hunter : hunter1) {
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Wolf\") " + Config.getDietByAnimal(hunter, "Wolf"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Boa\") " + Config.getDietByAnimal(hunter, "Boa"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Fox\") " + Config.getDietByAnimal(hunter, "Fox"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Bear\") " + Config.getDietByAnimal(hunter, "Bear"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Eagle\") " + Config.getDietByAnimal(hunter, "Eagle"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Horse\")" + Config.getDietByAnimal(hunter, "Horse"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Deer\") " + Config.getDietByAnimal(hunter, "Deer"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Rabbit\") " + Config.getDietByAnimal(hunter, "Rabbit"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Mouse\") " + Config.getDietByAnimal(hunter, "Mouse"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Goat\") " + Config.getDietByAnimal(hunter, "Goat"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Sheep\") " + Config.getDietByAnimal(hunter, "Sheep"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Boar\") " + Config.getDietByAnimal(hunter, "Boar"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Buffalo\") " + Config.getDietByAnimal(hunter, "Buffalo"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Duck\") " + Config.getDietByAnimal(hunter, "Duck"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Caterpillar\") " + Config.getDietByAnimal(hunter, "Caterpillar"));
//            System.out.println("getDietByAnimal(\"" + hunter + "\",\"Plant\") " + Config.getDietByAnimal(hunter, "Plant"));
//            System.out.println();
//        }
//        System.out.println(Config.getIcon("Wolf"));
//        System.out.println(Config.getWeight("Wolf"));
//        int breedingPeriod = ThreadLocalRandom.current().nextInt(Config.getBreedingPeriod("Wolf"));
//        System.out.println(breedingPeriod);
        new Executor().execute(new Island());

    }
}