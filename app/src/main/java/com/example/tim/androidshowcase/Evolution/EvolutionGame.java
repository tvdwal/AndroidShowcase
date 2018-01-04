package com.example.tim.androidshowcase.Evolution;

import java.util.List;

/**
 * Created by tvandewal on 4-1-2018.
 */

public class EvolutionGame {
    List<Biome> biomes;
    int generation = 0;

    public EvolutionGame(int size)
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                biomes.add(new Biome(i,j));
            }
        }
    }

    public void initiateGame()
    {
        // Generate creatures per biome
    }

    public void nextGeneration()
    {

    }
}
