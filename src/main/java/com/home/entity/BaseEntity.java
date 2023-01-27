package com.home.entity;

import com.home.config.Config;

public abstract class BaseEntity {
    public static String icon;
    protected String entityType;
    protected int weight;
    protected String name;

    protected boolean isAlive;

    public BaseEntity() {
        entityType = getClass().getSimpleName();
        icon = Config.getIcons().get(entityType);
        weight = Config.getWeight(entityType);

        name = getName();
        isAlive = true;
    }
    public abstract String getName();

    public void die() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getWeight() {
        return weight;
    }

    public String getEntityType() {
        return entityType;
    }
}