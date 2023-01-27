package com.home.areas;
import com.home.config.Config;
import com.home.entity.animals.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Island {
    private final Area[][] areas = new Area[Config.getSizeHorizontal()][Config.getSizeVertical()];

    public Island() {
        initialize();
    }

    public void initialize() {
        for (int x = 0; x < areas.length; x++) {
            for (int y = 0; y < areas[x].length; y++) {
                areas[x][y] = new Area(x, y);
            }
        }
    }

    public Area getAreaByCoordinatees(int x, int y) {
        return areas[x][y];
    }

    public void print() {
        for (int x = 0; x < areas.length; x++) {
            for (int y = 0; y < areas[x].length; y++) {
                System.out.println(areas[x][y].toString());
            }
        }
    }

    public void moveAnimalsOnArea(Area area, Animal animalRunner) {
        if (animalRunner instanceof Animal) {
            Animal animal = animalRunner;
            if (animal instanceof CanMove) {
                Area areaToMove = serchingAreaToMove(area, animal);
                move(area, animal, areaToMove);
            }
        }
    }

    private void move(Area area, Animal animal, Area areaToMove) {
        int x = area.getCoordinates().getX();
        int y = area.getCoordinates().getY();
        animal.setActionComplite(true);
        areas[x][y].comeOrAway(animal, false);
        areas[areaToMove.getCoordinates().getX()][areaToMove.getCoordinates().getY()].comeOrAway(animal, true);
//        System.out.println("[Area move()]: " + animal.getName() + " from Area[" + x + ", " + y + "] move to Area[" + areaToMove.getCoordinates().getX() + ", " + areaToMove.getCoordinates().getY() + "]");
    }

    private Area serchingAreaToMove(Area area, Animal animal) {
        Area checkedArea = area;
        if (!animal.isMoveFinished()) {
            animal.decrementCurrentMoveCount();
            List<Area> areasToMove = new ArrayList<>();
            int x = area.getCoordinates().getX();
            int y = area.getCoordinates().getY();

            if (x > 0) {
                if (canMoveHere(animal, areas[x - 1][y])) {
                    areasToMove.add(areas[x - 1][y]);
//                    System.out.println("[Area serchingAreaToMove(x > 0)]: " + animal.getName() + ": add to search Area[" + (x - 1) + ", " + y + "]");

                }
            }
            if (x < Config.getSizeHorizontal() - 1) {
                if (canMoveHere(animal, areas[x + 1][y])) {
                    areasToMove.add(areas[x + 1][y]);
//                    System.out.println("[Area serchingAreaToMove(x < Config.getSizeHorizontal() - 1 = " + (Config.getSizeHorizontal() - 1) + ")]: " + animal.getName() + ": add to search Area[" + (x + 1) + ", " + y + "]");

                }
            }
//        Система координат перевернута и начинается с левого верхнего угла
//        Движение вверх - уменьшение координаты Y, а движение вниз - увеличение
            if (y > 0) {
                if (canMoveHere(animal, areas[x][y - 1])) {
                    areasToMove.add(areas[x][y - 1]);
//                    System.out.println("[Area serchingAreaToMove(y > 0)]: " + animal.getName() + ": add to search Area[" + x + ", " + (y - 1) + "]");
                }
            }
            if (y < Config.getSizeVertical() - 1) {
                if (canMoveHere(animal, areas[x][y + 1])) {
                    areasToMove.add(areas[x][y + 1]);
//                    System.out.println("[Area serchingAreaToMove(y < Config.getSizeVertical() - 1 = " + (Config.getSizeVertical() - 1) + ")]: " + animal.getName() + ": add to search Area[" + x + ", " + (y + 1) + "]");
                }
            }
            checkedArea = areasToMove.get(ThreadLocalRandom.current().nextInt(areasToMove.size()));
//            System.out.println("[Area serchingAreaToMove()]: " + animal.getName() +
//                    ": checked on this round Area [" +
//                    checkedArea.getCoordinates().getX() + ", " + checkedArea.getCoordinates().getY() + "]");

            checkedArea = serchingAreaToMove(checkedArea, animal);
        }
//        System.out.println("[Area serchingAreaToMove()]: " + animal.getName() +
//                ": Final Area [" +
//                checkedArea.getCoordinates().getX() + ", " + checkedArea.getCoordinates().getY() + "]");
        return checkedArea;
    }

    private boolean canMoveHere(Animal animal, Area area) {
        if (animal instanceof Wolf) {
            return area.getCntWolf() < Config.getMaxCountEntitiesInArea("Wolf");
        } else if (animal instanceof Boa) {
            return area.getCntBoa() < Config.getMaxCountEntitiesInArea("Boa");
        } else if (animal instanceof Fox) {
            return area.getCntFox() < Config.getMaxCountEntitiesInArea("Fox");
        } else if (animal instanceof Bear) {
            return area.getCntBear() < Config.getMaxCountEntitiesInArea("Bear");
        } else if (animal instanceof Eagle) {
            return area.getCntEagle() < Config.getMaxCountEntitiesInArea("Eagle");
        } else if (animal instanceof Horse) {
            return area.getCntHorse() < Config.getMaxCountEntitiesInArea("Horse");
        } else if (animal instanceof Deer) {
            return area.getCntDeer() < Config.getMaxCountEntitiesInArea("Deer");
        } else if (animal instanceof Rabbit) {
            return area.getCntRabbit() < Config.getMaxCountEntitiesInArea("Rabbit");
        } else if (animal instanceof Mouse) {
            return area.getCntMouse() < Config.getMaxCountEntitiesInArea("Mouse");
        } else if (animal instanceof Goat) {
            return area.getCntGoat() < Config.getMaxCountEntitiesInArea("Goat");
        } else if (animal instanceof Sheep) {
            return area.getCntSheep() < Config.getMaxCountEntitiesInArea("Sheep");
        } else if (animal instanceof Boar) {
            return area.getCntBoar() < Config.getMaxCountEntitiesInArea("Boar");
        } else if (animal instanceof Buffalo) {
            return area.getCntBuffalo() < Config.getMaxCountEntitiesInArea("Buffalo");
        } else if (animal instanceof Duck) {
            return area.getCntDuck() < Config.getMaxCountEntitiesInArea("Duck");
        } else if (animal instanceof Caterpillar) {
            return area.getCntCaterpillar() < Config.getMaxCountEntitiesInArea("Caterpillar");
        } else {
            return false;
        }
    }
}
