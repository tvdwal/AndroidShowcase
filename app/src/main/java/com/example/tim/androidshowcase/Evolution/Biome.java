package com.example.tim.androidshowcase.Evolution;

import java.util.Random;

/**
 * Created by tvandewal on 4-1-2018.
 */

public class Biome {
    private Random random;
    private int xValue;
    private int yValue;
    private int temperature;
    private int capacity;

    public Biome(int x, int y)
    {
        Random random = new Random();
        xValue = x;
        yValue = y;
        temperature = random.nextInt(100);
        capacity = 10000 + random.nextInt(10000);
    }
}
