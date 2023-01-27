package com.home.areas;

import com.home.config.Config;
import com.home.entity.BaseEntity;
import com.home.entity.animals.*;
import com.home.entity.plants.Plant;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Area {

    private int cntWolf;
    private int cntBoa;
    private int cntFox;
    private int cntBear;
    private int cntEagle;
    private int cntHorse;
    private int cntDeer;
    private int cntRabbit;
    private int cntMouse;
    private int cntGoat;
    private int cntSheep;
    private int cntBoar;
    private int cntBuffalo;
    private int cntDuck;
    private int cntCaterpillar;
    private int cntPlant;
    private Map<String, Integer> maxCountEntitiesInArea = Config.getMaxCountEntitiesInArea();
    private Map<String, Integer> countEntitiesInAreaOnInit = Config.getCountEntitiesInAreaOnInit();
    private final Map<String, BaseEntity> entities;
    private final Map<String, BaseEntity> preys;
    private final Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Area(int x, int y) {
        coordinates = new Coordinates(x, y);
        entities = new HashMap<>();
        preys = new HashMap<>();
        initArea();
        System.out.println("[Area[" + x + "," + y + "] Area()] Init:\n" +
                Config.getIcons().get("Wolf") + "\t" + cntWolf + "\t|\t" +
                Config.getIcons().get("Boa") + "\t" + cntBoa + "\t|\t" +
                Config.getIcons().get("Fox") + "\t" + cntFox + "\t|\t" +
                Config.getIcons().get("Bear") + "\t" + cntFox + "\n" +
                Config.getIcons().get("Eagle") + "\t" + cntEagle + "\t|\t" +
                Config.getIcons().get("Horse") + "\t" + cntHorse + "\t|\t" +
                Config.getIcons().get("Deer") + "\t" + cntDeer + "\t|\t" +
                Config.getIcons().get("Rabbit") + "\t" + cntRabbit + "\n" +
                Config.getIcons().get("Mouse") + "\t" + cntMouse + "\t|\t" +
                Config.getIcons().get("Goat") + "\t" + cntGoat + "\t|\t" +
                Config.getIcons().get("Sheep") + "\t" + cntSheep + "\t|\t" +
                Config.getIcons().get("Boar") + "\t" + cntBoar + "\n" +
                Config.getIcons().get("Buffalo") + "\t" + cntBuffalo + "\t|\t" +
                Config.getIcons().get("Duck") + "\t" + cntDuck + "\t|\t" +
                Config.getIcons().get("Caterpillar") + "\t" + cntCaterpillar + "\t|\t" +
                Config.getIcons().get("Plant") + "\t" + cntPlant);
    }

    public int getCntWolf() {
        return cntWolf;
    }

    public int getCntBoa() {
        return cntBoa;
    }

    public int getCntFox() {
        return cntFox;
    }

    public int getCntBear() {
        return cntBear;
    }

    public int getCntEagle() {
        return cntEagle;
    }

    public int getCntHorse() {
        return cntHorse;
    }

    public int getCntDeer() {
        return cntDeer;
    }

    public int getCntRabbit() {
        return cntRabbit;
    }

    public int getCntMouse() {
        return cntMouse;
    }

    public int getCntGoat() {
        return cntGoat;
    }

    public int getCntSheep() {
        return cntSheep;
    }

    public int getCntBoar() {
        return cntBoar;
    }

    public int getCntBuffalo() {
        return cntBuffalo;
    }

    public int getCntDuck() {
        return cntDuck;
    }

    public int getCntCaterpillar() {
        return cntCaterpillar;
    }

    public int getCntPlant() {
        return cntPlant;
    }

    private final Lock lock = new ReentrantLock(true);

    public Set<String> getentities() {
        return entities.keySet();
    }

    public BaseEntity getItemByKey(String key) {
        return entities.get(key);
    }

    public Lock getLock() {
        return lock;
    }

    private void initArea() {
        initWolf(countEntitiesInAreaOnInit.get("Wolf"), maxCountEntitiesInArea.get("Wolf"));
        initBoa(countEntitiesInAreaOnInit.get("Boa"), maxCountEntitiesInArea.get("Boa"));
        initFox(countEntitiesInAreaOnInit.get("Fox"), maxCountEntitiesInArea.get("Fox"));
        initBear(countEntitiesInAreaOnInit.get("Bear"), maxCountEntitiesInArea.get("Bear"));
        initEagle(countEntitiesInAreaOnInit.get("Eagle"), maxCountEntitiesInArea.get("Eagle"));
        initHorse(countEntitiesInAreaOnInit.get("Horse"), maxCountEntitiesInArea.get("Horse"));
        initDeer(countEntitiesInAreaOnInit.get("Deer"), maxCountEntitiesInArea.get("Deer"));
        initRabbit(countEntitiesInAreaOnInit.get("Rabbit"), maxCountEntitiesInArea.get("Rabbit"));
        initMouse(countEntitiesInAreaOnInit.get("Mouse"), maxCountEntitiesInArea.get("Mouse"));
        initGoat(countEntitiesInAreaOnInit.get("Goat"), maxCountEntitiesInArea.get("Goat"));
        initSheep(countEntitiesInAreaOnInit.get("Sheep"), maxCountEntitiesInArea.get("Sheep"));
        initBoar(countEntitiesInAreaOnInit.get("Boar"), maxCountEntitiesInArea.get("Boar"));
        initBuffalo(countEntitiesInAreaOnInit.get("Buffalo"), maxCountEntitiesInArea.get("Buffalo"));
        initDuck(countEntitiesInAreaOnInit.get("Duck"), maxCountEntitiesInArea.get("Duck"));
        initCaterpillar(countEntitiesInAreaOnInit.get("Caterpillar"), maxCountEntitiesInArea.get("Caterpillar"));
        initPlant(countEntitiesInAreaOnInit.get("Plant"), maxCountEntitiesInArea.get("Plant"));
    }

    private void initWolf(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Wolf wolf = new Wolf(true);
            entities.put(wolf.getName(), wolf);
            count--;
            cntWolf++;
        }
    }

    private void initBoa(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Boa boa = new Boa(true);
            entities.put(boa.getName(), boa);
            count--;
            cntBoa++;
        }
    }

    private void initFox(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Fox fox = new Fox(true);
            entities.put(fox.getName(), fox);
            count--;
            cntFox++;
        }
    }

    private void initBear(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Bear bear = new Bear(true);
            entities.put(bear.getName(), bear);
            count--;
            cntBear++;
        }
    }

    private void initEagle(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Eagle eagle = new Eagle(true);
            entities.put(eagle.getName(), eagle);
            count--;
            cntEagle++;
        }
    }

    private void initHorse(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Horse horse = new Horse(true);
            entities.put(horse.getName(), horse);
            count--;
            cntHorse++;
        }
    }

    private void initDeer(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Deer deer = new Deer(true);
            entities.put(deer.getName(), deer);
            count--;
            cntDeer++;
        }
    }

    private void initRabbit(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Rabbit rabbit = new Rabbit(true);
            entities.put(rabbit.getName(), rabbit);
            count--;
            cntRabbit++;
        }
    }

    private void initMouse(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Mouse mouse = new Mouse(true);
            entities.put(mouse.getName(), mouse);
            count--;
            cntMouse++;
        }
    }

    private void initGoat(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Goat goat = new Goat(true);
            entities.put(goat.getName(), goat);
            count--;
            cntGoat++;
        }
    }

    private void initSheep(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Sheep sheep = new Sheep(true);
            entities.put(sheep.getName(), sheep);
            count--;
            cntSheep++;
        }
    }

    private void initBoar(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Boar boar = new Boar(true);
            entities.put(boar.getName(), boar);
            count--;
            cntBoar++;
        }
    }

    private void initBuffalo(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Buffalo buffalo = new Buffalo(true);
            entities.put(buffalo.getName(), buffalo);
            count--;
            cntBuffalo++;
        }
    }

    private void initDuck(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Duck duck = new Duck(true);
            entities.put(duck.getName(), duck);
            count--;
            cntDuck++;
        }
    }

    private void initCaterpillar(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Caterpillar caterpillar = new Caterpillar(true);
            entities.put(caterpillar.getName(), caterpillar);
            count--;
            cntCaterpillar++;
        }
    }

    private void initPlant(int maxCntOnInit, int maxCntOnArea) {
        int count;
        if (maxCntOnArea >= maxCntOnInit) count = maxCntOnInit;
        else count = maxCntOnArea;
        while (count > 0) {
            Plant plant = new Plant();
            entities.put(plant.getName(), plant);
            count--;
            cntPlant++;
        }
    }

    public void eatAnimals(Animal animalHunter) {
        if (animalHunter instanceof CanEat) {
            Animal hunter = animalHunter;
            hunter.setActionComplite(true);
            if (hunter.getWeight() < Config.getWeight(hunter.getEntityType())) {
//                System.out.println("[Area eatAnimals()] HUNTER\n" + hunter.toString());
                int preysCounter = 0;
                for (Map.Entry<String, BaseEntity> prey : entities.entrySet()) {
                    BaseEntity food = prey.getValue();
                    if ((!(food.getEntityType().equals(hunter.getEntityType()))) && (food.isAlive()) && ((Config.getDietByAnimal(hunter.getEntityType(), food.getEntityType())) > 0))
                        preysCounter++;
                }
//                System.out.println("[Area eatAnimals()] Preys count in area: " + preysCounter);
                if (preysCounter > 0) {
                    int foodChoise = ThreadLocalRandom.current().nextInt(1, preysCounter + 1);
//                    System.out.println("[Area eatAnimals()] Food Choise: " + foodChoise);

                    for (Map.Entry<String, BaseEntity> prey : entities.entrySet()) {
                        BaseEntity food = prey.getValue();
                        if ((!(food.getEntityType().equals(hunter.getEntityType())))
                                && (food.isAlive())
                                && ((Config.getDietByAnimal(hunter.getEntityType(), food.getEntityType())) > 0)) {
                            if (foodChoise == 1) {

//                                System.out.println("[Area eatAnimals()] Diet " + Config.getDietByAnimal(hunter.getEntityType(), food.getEntityType()));
                                int diet = ThreadLocalRandom.current().nextInt(1, 101);
//                                System.out.println("[Area eatAnimals()] Current Diet " + diet + "\n");

                                if (Config.getDietByAnimal(hunter.getEntityType(), food.getEntityType()) >= diet) {
                                    hunter.eat(prey.getValue().getWeight(), prey.getValue().getName());
//                                    System.out.println("[Area eatAnimals()] FOOD\n" + food.toString() + "\n" +
//                                            "Hunter type: " + hunter.getEntityType() + "\n" +
//                                            "Food type  : " + food.getEntityType() + "\n" +
//                                            "Result     : " + !(food.getEntityType().equals(hunter.getEntityType())) + "\n");
                                    prey.getValue().die();
                                    break;
                                }
                            }
                            foodChoise--;
                        }
                    }
                }
            }
        }
    }

    public void reproduceAnimal(Animal animalParent) {
        if (animalParent instanceof Spawn) {
            Animal parent1 = animalParent;
//            System.out.println("[Area reproduceAnimal()] " + parent1.getName() + "is ready to spawn :" + parent1.isReadyToSpawn());
            if (parent1.isReadyToSpawn()) {
                Map<String, BaseEntity> copyItems = new HashMap<>(entities);
                for (Map.Entry<String, BaseEntity> item2 : copyItems.entrySet()) {
                    Animal parent2 = (Animal) item2.getValue();
                    if ((parent1.getEntityType().equals(parent2.getEntityType()))
                            && (!(parent1.getName()).equals(parent2.getName()))
                            && (!parent2.isActionComplite())) {
//                        System.out.println("[Area reproduceAnimal()] " + parent2.getName() + "is ready to spawn :" + parent2.isReadyToSpawn());
                        if (parent2.isReadyToSpawn()) {
                            int population = ThreadLocalRandom.current().nextInt(parent1.getMaxNumbersOfChilds() + 1);
                            if (checkPopulation(parent1) < population) {
                                population = checkPopulation(parent1);
                            }
                            parent1.spawn(parent2);
                            while (population > 0) {
                                birthOrDieAnimalOnLocation(parent1, true);
                                population--;
                            }
                            parent1.setActionComplite(true);
                            parent2.setActionComplite(true);
                        }
                    }
                }
            }

        }

    }

    private void birthOrDieAnimalOnLocation(Animal animal, boolean isAlive) {
        if (animal instanceof Wolf)
            comeOrAway(new Wolf(false), isAlive);
        else if (animal instanceof Boa)
            comeOrAway(new Boa(false), isAlive);
        else if (animal instanceof Fox)
            comeOrAway(new Fox(false), isAlive);
        else if (animal instanceof Bear)
            comeOrAway(new Bear(false), isAlive);
        else if (animal instanceof Eagle)
            comeOrAway(new Eagle(false), isAlive);
        else if (animal instanceof Horse)
            comeOrAway(new Horse(false), isAlive);
        else if (animal instanceof Deer)
            comeOrAway(new Deer(false), isAlive);
        else if (animal instanceof Rabbit)
            comeOrAway(new Rabbit(false), isAlive);
        else if (animal instanceof Mouse)
            comeOrAway(new Mouse(false), isAlive);
        else if (animal instanceof Goat)
            comeOrAway(new Goat(false), isAlive);
        else if (animal instanceof Sheep)
            comeOrAway(new Sheep(false), isAlive);
        else if (animal instanceof Boar)
            comeOrAway(new Boar(false), isAlive);
        else if (animal instanceof Buffalo)
            comeOrAway(new Buffalo(false), isAlive);
        else if (animal instanceof Duck)
            comeOrAway(new Duck(false), isAlive);
        else if (animal instanceof Caterpillar)
            comeOrAway(new Caterpillar(false), isAlive);
    }

    public Set<String> getEntities() {
        return entities.keySet();
    }

    public void plantGrass() {
        int plant = 0;
        plant = ThreadLocalRandom.current().nextInt(Config.getMaxNumberOfChilds("Plant"));
        if (plant + cntPlant > Config.getMaxCountEntitiesInArea().get("Plant"))
            plant = Config.getMaxCountEntitiesInArea("Plant") - cntPlant;
//        System.out.println("[Area plantGrass()] Всего растений на локации: " + cntPlant + "\t|\tБудет выращено растений: " + plant);
        while (plant > 0) {
            comeOrAway(new Plant(), true);
            plant--;
        }
    }

    public void comeOrAway(BaseEntity obj, boolean come) {
        int value;
        if (come)
            value = 1;
        else
            value = -1;
        if (obj instanceof Wolf)
            cntWolf += value;
        else if (obj instanceof Boa)
            cntBoa += value;
        else if (obj instanceof Fox)
            cntFox += value;
        else if (obj instanceof Bear)
            cntBear += value;
        else if (obj instanceof Eagle)
            cntEagle += value;
        else if (obj instanceof Horse)
            cntHorse += value;
        else if (obj instanceof Deer)
            cntDeer += value;
        else if (obj instanceof Rabbit)
            cntRabbit += value;
        else if (obj instanceof Mouse)
            cntMouse += value;
        else if (obj instanceof Goat)
            cntGoat += value;
        else if (obj instanceof Sheep)
            cntSheep += value;
        else if (obj instanceof Boar)
            cntBoar += value;
        else if (obj instanceof Buffalo)
            cntBuffalo += value;
        else if (obj instanceof Duck)
            cntDuck += value;
        else if (obj instanceof Caterpillar)
            cntCaterpillar += value;
        else if (obj instanceof Plant)
            cntPlant += value;
        if (come) {
            if (obj instanceof Animal)
                entities.put((obj).getName(), obj);
            else if (obj instanceof Plant)
                entities.put((obj).getName(), obj);
        } else {
            if (obj instanceof Animal)
                entities.remove((obj).getName());
            else if (obj instanceof Plant)
                entities.remove((obj).getName());
        }
    }

    private int checkPopulation(Animal animal) {
        if (animal instanceof Wolf)
            return Config.getMaxCountEntitiesInArea("Wolf") - cntWolf;
        else if (animal instanceof Boa)
            return Config.getMaxCountEntitiesInArea("Boa") - cntBoa;
        else if (animal instanceof Fox)
            return Config.getMaxCountEntitiesInArea("Fox") - cntFox;
        else if (animal instanceof Bear)
            return Config.getMaxCountEntitiesInArea("Bear") - cntBear;
        else if (animal instanceof Eagle)
            return Config.getMaxCountEntitiesInArea("Eagle") - cntEagle;
        else if (animal instanceof Horse)
            return Config.getMaxCountEntitiesInArea("Horse") - cntHorse;
        else if (animal instanceof Deer)
            return Config.getMaxCountEntitiesInArea("Deer") - cntDeer;
        else if (animal instanceof Rabbit)
            return Config.getMaxCountEntitiesInArea("Rabbit") - cntRabbit;
        else if (animal instanceof Mouse)
            return Config.getMaxCountEntitiesInArea("Mouse") - cntMouse;
        else if (animal instanceof Goat)
            return Config.getMaxCountEntitiesInArea("Goat") - cntGoat;
        else if (animal instanceof Sheep)
            return Config.getMaxCountEntitiesInArea("Sheep") - cntSheep;
        else if (animal instanceof Boar)
            return Config.getMaxCountEntitiesInArea("Boar") - cntBoar;
        else if (animal instanceof Buffalo)
            return Config.getMaxCountEntitiesInArea("Buffalo") - cntBuffalo;
        else if (animal instanceof Duck)
            return Config.getMaxCountEntitiesInArea("Duck") - cntDuck;
        else if (animal instanceof Caterpillar)
            return Config.getMaxCountEntitiesInArea("Caterpillar") - cntCaterpillar;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "[Area[" + coordinates.getX() + "," + coordinates.getY() + "] toString()]:\n" +
                Config.getIcons().get("Wolf") + "\t" + cntWolf + "\t|\t" +
                Config.getIcons().get("Boa") + "\t" + cntBoa + "\t|\t" +
                Config.getIcons().get("Fox") + "\t" + cntFox + "\t|\t" +
                Config.getIcons().get("Bear") + "\t" + cntFox + "\n" +
                Config.getIcons().get("Eagle") + "\t" + cntEagle + "\t|\t" +
                Config.getIcons().get("Horse") + "\t" + cntHorse + "\t|\t" +
                Config.getIcons().get("Deer") + "\t" + cntDeer + "\t|\t" +
                Config.getIcons().get("Rabbit") + "\t" + cntRabbit + "\n" +
                Config.getIcons().get("Mouse") + "\t" + cntMouse + "\t|\t" +
                Config.getIcons().get("Goat") + "\t" + cntGoat + "\t|\t" +
                Config.getIcons().get("Sheep") + "\t" + cntSheep + "\t|\t" +
                Config.getIcons().get("Boar") + "\t" + cntBoar + "\n" +
                Config.getIcons().get("Buffalo") + "\t" + cntBuffalo + "\t|\t" +
                Config.getIcons().get("Duck") + "\t" + cntDuck + "\t|\t" +
                Config.getIcons().get("Caterpillar") + "\t" + cntCaterpillar + "\t|\t" +
                Config.getIcons().get("Plant") + "\t" + cntPlant;
    }
}