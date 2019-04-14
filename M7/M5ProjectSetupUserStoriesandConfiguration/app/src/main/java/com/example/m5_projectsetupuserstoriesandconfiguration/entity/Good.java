package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;
import java.util.Random;

class Good implements Serializable {
    private GoodType typeOfGood;
    private final int minimumTechLvlBuy;
    private final int minimumTechLvlSell;
    private final Tech optimalTechLevel;
    private final int priceIncrease;
    private final double variance;
    private final RadicalEvent radicalPriceEvent;
    private final Resources expensivePrice;
    private final Resources cheapPrice;
    private final int minPrice;
    private final int maxPrice;
    private final Random rand = new Random();

    private Good(){
        this.typeOfGood = GoodType.values()[rand.nextInt(GoodType.values().length)];
        this.minimumTechLvlBuy = typeOfGood.getMtlp();
        this.minimumTechLvlSell = typeOfGood.getMtlu();
        this.optimalTechLevel =typeOfGood.getTtp();
        this.priceIncrease = typeOfGood.getIpl();
        this.variance = typeOfGood.getVar();
        this.radicalPriceEvent =typeOfGood.getIe();
        this.expensivePrice = typeOfGood.getCr();
        this.cheapPrice = typeOfGood.getEr();
        this.minPrice = this.typeOfGood.getBasePrice();
        double MAXPRICEFACTOR = 3;
        this.maxPrice = (int) (this.typeOfGood.getBasePrice()* MAXPRICEFACTOR);
        int marketPrice = minPrice;


    }

    public Good(GoodType typeOfGood){
        this();
        this.typeOfGood = typeOfGood;
        }

    public Good(GoodType typeOfGood, int minimumTechLvlBuy, int minimumTechLvlSell,
                Tech optimalTechLevel, int priceIncrease, double variance,
                RadicalEvent radicalPriceEvent,
                Resources expensivePrice, Resources cheapPrice, int minPrice, int maxPrice) {
        this.typeOfGood = typeOfGood;
        this.minimumTechLvlBuy = minimumTechLvlBuy;
        this.minimumTechLvlSell = minimumTechLvlSell;
        this.optimalTechLevel = optimalTechLevel;
        this.priceIncrease = priceIncrease;
        this.variance = variance;
        this.radicalPriceEvent = radicalPriceEvent;
        this.expensivePrice = expensivePrice;
        this.cheapPrice = cheapPrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

}
