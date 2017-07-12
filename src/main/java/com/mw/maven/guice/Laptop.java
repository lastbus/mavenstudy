package com.mw.maven.guice;

/**
 * Created by make on 2017/7/5.
 */
public class Laptop {

    private String model;
    private String price;

    public Laptop(){
        this.model = "HP 323233232";
        this.price = "$545034";
    }

    public String toString(){
        return "[Laptop: " + model + "," + price + "]";
    }
}
