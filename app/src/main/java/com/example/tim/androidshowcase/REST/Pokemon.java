package com.example.tim.androidshowcase.REST;

/**
 * Created by Tim on 12-7-2017.
 */

public class Pokemon {

    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("This is %s, a pokemon with id '%d', weighing %dg with a height of %dcm.", getName(), getId(), getWeight()*100, getHeight()*10);
    }
}
