package com.home.entity.plants;

import com.home.config.Config;
import com.home.entity.BaseEntity;

public class Plant extends BaseEntity {
    private static int indexPlant = 0;

    public Plant() {
        name = icon + ++indexPlant;
//        System.out.println("[Plant Plant()] " + entityType + " init:\n" +
//                "Icon:                 " + icon + "\n" +
//                "Name:                 " + getName() + "\n" +
//                "Weight:               " + weight + "\n");
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
