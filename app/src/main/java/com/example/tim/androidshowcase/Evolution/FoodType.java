package com.example.tim.androidshowcase.Evolution;

/**
 * Created by tvandewal on 4-1-2018.
 */

public enum FoodType {
    HERBIVORE("Herbivore", 0),
    CARNIVORE("Carnivore", 1),
    OMNIVORE("Omnivore",2);

    private String stringValue;
    private int intValue;

    private FoodType(String toString, int toInt)
    {
        stringValue = toString;
        intValue = toInt;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
