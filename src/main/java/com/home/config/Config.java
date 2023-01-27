package com.home.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {
    private static int sizeHorizontal;
    private static int sizeVertical;
    private static boolean stopOption;
    private static int finalStep;
    private static String areaNamePrefix;
    private static final Map<String, Integer> wolfDiet = new HashMap<>();
    private static Map<String, Integer> boaDiet = new HashMap<>();
    private static Map<String, Integer> foxDiet = new HashMap<>();
    private static Map<String, Integer> bearDiet = new HashMap<>();
    private static Map<String, Integer> eagleDiet = new HashMap<>();
    private static Map<String, Integer> horseDiet = new HashMap<>();
    private static Map<String, Integer> deerDiet = new HashMap<>();
    private static Map<String, Integer> rabbitDiet = new HashMap<>();
    private static Map<String, Integer> mouseDiet = new HashMap<>();
    private static Map<String, Integer> goatDiet = new HashMap<>();
    private static Map<String, Integer> sheepDiet = new HashMap<>();
    private static Map<String, Integer> boarDiet = new HashMap<>();
    private static Map<String, Integer> buffaloDiet = new HashMap<>();
    private static Map<String, Integer> duckDiet = new HashMap<>();
    private static Map<String, Integer> caterpillarDiet = new HashMap<>();
    private static Map<String, String> icons = new HashMap<>();
    private static Map<String, Integer> maxCountEntitiesInArea = new HashMap<>();
    private static Map<String, Integer> countEntitiesInAreaOnInit = new HashMap<>();
    private static Map<String, Integer> weight = new HashMap<>();
    private static Map<String, Integer> maxMoveSpeeds = new HashMap<>();
    private static Map<String, Integer> maxFoodInAnimals = new HashMap<>();
    private static Map<String, Integer> breedingPeriods = new HashMap<>();
    private static Map<String, Integer> starvingsInStep = new HashMap<>();
    private static Map<String, Integer> maxNumbersOfChilds = new HashMap<>();

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/island.properties")) {
            Properties properties = new Properties();
            properties.load(fis);
            sizeHorizontal = Integer.parseInt(properties.getProperty("sizeHorizontal", "100"));
            sizeVertical = Integer.parseInt(properties.getProperty("sizeVertical", "20"));
            stopOption = Boolean.parseBoolean(properties.getProperty("stopOption"));
            finalStep = Integer.parseInt(properties.getProperty("finalStep", "5"));
            areaNamePrefix = properties.getProperty("areaNamePrefix", "Area");

            String[] species = properties.getProperty("species").split("/");
            String[] wolfDietList = properties.getProperty("wolfDiet").split("/");
            String[] boaDietList = properties.getProperty("boaDiet").split("/");
            String[] foxDietList = properties.getProperty("foxDiet").split("/");
            String[] bearDietList = properties.getProperty("bearDiet").split("/");
            String[] eagleDietList = properties.getProperty("eagleDiet").split("/");
            String[] horseDietList = properties.getProperty("horseDiet").split("/");
            String[] deerDietList = properties.getProperty("deerDiet").split("/");
            String[] rabbitDietList = properties.getProperty("rabbitDiet").split("/");
            String[] mouseDietList = properties.getProperty("mouseDiet").split("/");
            String[] goatDietList = properties.getProperty("goatDiet").split("/");
            String[] sheepDietList = properties.getProperty("sheepDiet").split("/");
            String[] boarDietList = properties.getProperty("boarDiet").split("/");
            String[] buffaloDietList = properties.getProperty("buffaloDiet").split("/");
            String[] duckDietList = properties.getProperty("duckDiet").split("/");
            String[] caterpillarDietList = properties.getProperty("caterpillarDiet").split("/");
            String[] iconsList = properties.getProperty("icons").split("/");
            String[] weightList = properties.getProperty("weight").split("/");
            String[] maxCountEntitiesInAreaList = properties.getProperty("maxCountEntitiesInArea").split("/");
            String[] countEntitiesInAreaOnInitList = properties.getProperty("countEntitiesInAreaOnInit").split("/");
            String[] maxMoveSpeedsList = properties.getProperty("maxMoveSpeeds").split("/");
            String[] maxFoodInAnimalsList = properties.getProperty("maxFoodInAnimals").split("/");
            String[] breedingPeriodsList = properties.getProperty("breedingPeriods").split("/");
            String[] starvingsInStepList = properties.getProperty("starvingsInStep").split("/");
            String[] maxNumbersOfChildsList = properties.getProperty("maxNumbersOfChilds").split("/");
            for (int i = 0; i < species.length; i++) {
                wolfDiet.put(species[i], Integer.parseInt(wolfDietList[i]));
                boaDiet.put(species[i], Integer.parseInt(boaDietList[i]));
                foxDiet.put(species[i], Integer.parseInt(foxDietList[i]));
                bearDiet.put(species[i], Integer.parseInt(bearDietList[i]));
                eagleDiet.put(species[i], Integer.parseInt(eagleDietList[i]));
                horseDiet.put(species[i], Integer.parseInt(horseDietList[i]));
                deerDiet.put(species[i], Integer.parseInt(deerDietList[i]));
                rabbitDiet.put(species[i], Integer.parseInt(rabbitDietList[i]));
                mouseDiet.put(species[i], Integer.parseInt(mouseDietList[i]));
                goatDiet.put(species[i], Integer.parseInt(goatDietList[i]));
                sheepDiet.put(species[i], Integer.parseInt(sheepDietList[i]));
                boarDiet.put(species[i], Integer.parseInt(boarDietList[i]));
                buffaloDiet.put(species[i], Integer.parseInt(buffaloDietList[i]));
                duckDiet.put(species[i], Integer.parseInt(duckDietList[i]));
                caterpillarDiet.put(species[i], Integer.parseInt(caterpillarDietList[i]));
                icons.put(species[i], iconsList[i]);
                weight.put(species[i], Integer.parseInt(weightList[i]));
                maxCountEntitiesInArea.put(species[i], Integer.parseInt(maxCountEntitiesInAreaList[i]));
                countEntitiesInAreaOnInit.put(species[i], Integer.parseInt(countEntitiesInAreaOnInitList[i]));
                maxMoveSpeeds.put(species[i], Integer.parseInt(maxMoveSpeedsList[i]));
                maxFoodInAnimals.put(species[i], Integer.parseInt(maxFoodInAnimalsList[i]));
                breedingPeriods.put(species[i], Integer.parseInt(breedingPeriodsList[i]));
                starvingsInStep.put(species[i], Integer.parseInt(starvingsInStepList[i]));
                maxNumbersOfChilds.put(species[i], Integer.parseInt(maxNumbersOfChildsList[i]));
            }
        } catch (IOException e) {
            System.err.print("Данные из файла не загружены, используем настройки по-умолчанию");
            initializeDefaultProperties();
        }
    }

    private static void initializeDefaultProperties() {
        sizeHorizontal = 100;
        sizeVertical = 20;
        stopOption = true;
        finalStep = 5;
        areaNamePrefix = "Area";
        String[] species = "Wolf/Boa/Fox/Bear/Eagle/Horse/Deer/Rabbit/Mouse/Goat/Sheep/Boar/Buffalo/Duck/Caterpillar/Plant".split("/");
        String[] wolfDietList = "0/0/0/0/0/10/15/60/80/60/70/15/10/40/0/0".split("/");
        String[] boaDietList = "0/0/15/0/0/0/0/20/40/0/0/0/0/10/0/0".split("/");
        String[] foxDietList = "0/0/0/0/0/0/0/70/90/0/0/0/0/60/40/0".split("/");
        String[] bearDietList = "0/80/0/0/0/40/80/80/90/70/70/50/20/10/0/0".split("/");
        String[] eagleDietList = "0/0/10/0/0/0/0/90/90/0/0/0/0/80/0/0".split("/");
        String[] horseDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] deerDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] rabbitDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] mouseDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] goatDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] sheepDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] boarDietList = "0/0/0/0/0/0/0/0/50/0/0/0/0/0/90/100".split("/");
        String[] buffaloDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] duckDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/90/100".split("/");
        String[] caterpillarDietList = "0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/100".split("/");
        String[] iconsList = "Volk    /Udav    /Lisa    /Medved' /Orel    /Loshad' /Olen'   /Krolik  /Mish'   /Koza    /Ovca    /Kaban   /Buivol  /Utka    /Gusenica/Rastenie".split("/");
        String[] weightList = "50000/15000/8000/500000/6000/400000/300000/2000/50/60000/70000/400000/700000/1000/10/1000".split("/");
        String[] maxCountEntitiesInAreaList = "30/30/30/5/20/20/20/150/500/140/140/50/10/200/1000/200".split("/");
        String[] countEntitiesInAreaOnInitList = "15/15/15/2/10/10/10/75/250/70/70/25/5/100/500/100".split("/");
        String[] maxMoveSpeedsList = "3/1/2/2/3/4/4/2/1/3/3/2/3/4/0/0".split("/");
        String[] maxFoodInAnimalsList = "8000/3000/2000/80000/1000/60000/50000/4500/10/10000/15000/50000/100000/1500/10/0".split("/");
        String[] breedingPeriodsList = "45/9/60/365/182/365/365/8/3/182/365/73/365/33/2/2".split("/");
        String[] starvingsInStepList = "4000/1500/1000/40000/500/30000/25000/2250/10/5000/7500/25000/50000/750/3/0".split("/");
        String[] maxNumbersOfChildsList = "1/1/1/1/1/1/1/1/1/1/1/1/1/1/1/1".split("/");

        for (int i = 0; i < species.length; i++) {
            wolfDiet.put(species[i], Integer.parseInt(wolfDietList[i]));
            boaDiet.put(species[i], Integer.parseInt(boaDietList[i]));
            foxDiet.put(species[i], Integer.parseInt(foxDietList[i]));
            bearDiet.put(species[i], Integer.parseInt(bearDietList[i]));
            eagleDiet.put(species[i], Integer.parseInt(eagleDietList[i]));
            horseDiet.put(species[i], Integer.parseInt(horseDietList[i]));
            deerDiet.put(species[i], Integer.parseInt(deerDietList[i]));
            rabbitDiet.put(species[i], Integer.parseInt(rabbitDietList[i]));
            mouseDiet.put(species[i], Integer.parseInt(mouseDietList[i]));
            goatDiet.put(species[i], Integer.parseInt(goatDietList[i]));
            sheepDiet.put(species[i], Integer.parseInt(sheepDietList[i]));
            boarDiet.put(species[i], Integer.parseInt(boarDietList[i]));
            buffaloDiet.put(species[i], Integer.parseInt(buffaloDietList[i]));
            duckDiet.put(species[i], Integer.parseInt(duckDietList[i]));
            caterpillarDiet.put(species[i], Integer.parseInt(caterpillarDietList[i]));
            icons.put(species[i], iconsList[i]);
            weight.put(species[i], Integer.parseInt(weightList[i]));
            maxCountEntitiesInArea.put(species[i], Integer.parseInt(maxCountEntitiesInAreaList[i]));
            countEntitiesInAreaOnInit.put(species[i], Integer.parseInt(countEntitiesInAreaOnInitList[i]));
            maxMoveSpeeds.put(species[i], Integer.parseInt(maxMoveSpeedsList[i]));
            maxFoodInAnimals.put(species[i], Integer.parseInt(maxFoodInAnimalsList[i]));
            breedingPeriods.put(species[i], Integer.parseInt(breedingPeriodsList[i]));
            starvingsInStep.put(species[i], Integer.parseInt(starvingsInStepList[i]));
            maxNumbersOfChilds.put(species[i], Integer.parseInt(maxNumbersOfChildsList[i]));
        }
    }

    public static int getDietByAnimal(String hunter, String prey) {
        if (hunter.equals(prey))
            return 0;
        else {
            return switch (hunter) {
                case "Wolf" -> wolfDiet.get(prey);
                case "Boa" -> boaDiet.get(prey);
                case "Fox" -> foxDiet.get(prey);
                case "Bear" -> bearDiet.get(prey);
                case "Eagle" -> eagleDiet.get(prey);
                case "Horse" -> horseDiet.get(prey);
                case "Deer" -> deerDiet.get(prey);
                case "Rabbit" -> rabbitDiet.get(prey);
                case "Mouse" -> mouseDiet.get(prey);
                case "Goat" -> goatDiet.get(prey);
                case "Sheep" -> sheepDiet.get(prey);
                case "Boar" -> boarDiet.get(prey);
                case "Buffalo" -> buffaloDiet.get(prey);
                case "Duck" -> duckDiet.get(prey);
                case "Caterpillar" -> caterpillarDiet.get(prey);
                default -> 0;
            };
        }
    }

    public static int getSizeHorizontal() {
        return sizeHorizontal;
    }

    public static int getSizeVertical() {
        return sizeVertical;
    }

    public static boolean getStopOptions() {
        return stopOption;
    }

    public static int getFinalStep() {
        return finalStep;
    }

    public static String getAreaNamePrefix() {
        return areaNamePrefix;
    }

    public static Map<String, Integer> getWolfDiet() {
        return wolfDiet;
    }

    public static Map<String, Integer> getBoaDiet() {
        return boaDiet;
    }

    public static Map<String, Integer> getFoxDiet() {
        return foxDiet;
    }

    public static Map<String, Integer> getBearDiet() {
        return bearDiet;
    }

    public static Map<String, Integer> getEagleDiet() {
        return eagleDiet;
    }

    public static Map<String, Integer> getHorseDiet() {
        return horseDiet;
    }

    public static Map<String, Integer> getDeerDiet() {
        return deerDiet;
    }

    public static Map<String, Integer> getRabbitDiet() {
        return rabbitDiet;
    }

    public static Map<String, Integer> getMouseDiet() {
        return mouseDiet;
    }

    public static Map<String, Integer> getGoatDiet() {
        return goatDiet;
    }

    public static Map<String, Integer> getSheepDiet() {
        return sheepDiet;
    }

    public static Map<String, Integer> getBoarDiet() {
        return boarDiet;
    }

    public static Map<String, Integer> getBuffaloDiet() {
        return buffaloDiet;
    }

    public static Map<String, Integer> getDuckDiet() {
        return duckDiet;
    }

    public static Map<String, Integer> getCaterpillarDiet() {
        return caterpillarDiet;
    }

    public static Map<String, String> getIcons() {
        return icons;
    }
    public static String getIcon(String key) {
        return icons.get(key);
    }

    public static Map<String, Integer> getMaxCountEntitiesInArea() {
        return maxCountEntitiesInArea;
    }
    public static Integer getMaxCountEntitiesInArea(String key) {
        return maxCountEntitiesInArea.get(key);
    }

    public static Map<String, Integer> getCountEntitiesInAreaOnInit() {
        return countEntitiesInAreaOnInit;
    }

    public static Map<String, Integer> getWeights() {
        return weight;
    }
    public static Integer getWeight(String key) {
        return weight.get(key);
    }

    public static Map<String, Integer> getMaxMoveSpeeds() {
        return maxMoveSpeeds;
    }

    public static Map<String, Integer> getMaxFoodInAnimals() {
        return maxFoodInAnimals;
    }

    public static Map<String, Integer> getBreedingPeriods() {
        return breedingPeriods;
    }
    public static Integer getBreedingPeriod(String key) {
        return breedingPeriods.get(key);
    }

    public static Map<String, Integer> getStarvingsInStep() {
        return starvingsInStep;
    }

    public static Map<String, Integer> getMaxNumbersOfChilds() {
        return maxNumbersOfChilds;
    }
    public static Integer getMaxNumberOfChilds(String key) {
        return maxNumbersOfChilds.get(key);
    }
}
