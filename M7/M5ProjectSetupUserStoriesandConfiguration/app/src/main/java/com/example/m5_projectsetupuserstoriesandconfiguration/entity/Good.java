package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;
import java.util.Random;

public class Good implements Serializable {
    private final double MAXPPRICEFACTOR = 3;
    private GoodType typeOfGood;
    private int minimumTechLvlBuy;
    private int minimumTechLvlSell;
    private Tech optimalTechLevel;
    private int priceIncrese;
    private double variance;
    private RadicalEvent radicalPriceEvent;
    private Resources expensivePrice;
    private Resources cheapPrice;
    private int minPrice;
    private int maxPrice;
    private int marketPrice;

    public Good(){
        this.typeOfGood = GoodType.values()[new Random().nextInt(GoodType.values().length)];
        this.minimumTechLvlBuy = typeOfGood.getMtlp();
        this.minimumTechLvlSell = typeOfGood.getMtlu();
        this.optimalTechLevel =typeOfGood.getTtp();
        this.priceIncrese = typeOfGood.getIpl();
        this.variance = typeOfGood.getVar();
        this.radicalPriceEvent =typeOfGood.getIe();
        this.expensivePrice = typeOfGood.getCr();
        this.cheapPrice = typeOfGood.getEr();
        this.minPrice = this.typeOfGood.getBasePrice();
        this.maxPrice = (int) (this.typeOfGood.getBasePrice()* MAXPPRICEFACTOR);
        this.marketPrice = minPrice;


    }

    public Good(GoodType typeOfGood){
        this();
        this.typeOfGood = typeOfGood;
        }

    public Good(GoodType typeOfGood, int minimumTechLvlBuy, int minimumTechLvlSell,
                Tech optimalTechLevel, int priceIncrese, double variance, RadicalEvent radicalPriceEvent,
                Resources expensivePrice, Resources cheapPrice, int minPrice, int maxPrice) {
        this.typeOfGood = typeOfGood;
        this.minimumTechLvlBuy = minimumTechLvlBuy;
        this.minimumTechLvlSell = minimumTechLvlSell;
        this.optimalTechLevel = optimalTechLevel;
        this.priceIncrese = priceIncrese;
        this.variance = variance;
        this.radicalPriceEvent = radicalPriceEvent;
        this.expensivePrice = expensivePrice;
        this.cheapPrice = cheapPrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }


    public GoodType getTypeOfGood() {
        return typeOfGood;
    }

    public int getMinimumTechLvlBuy() {
        return minimumTechLvlBuy;
    }

    public int getMinimumTechLvlSell() {
        return minimumTechLvlSell;
    }

    public Tech getOptimalTechLevel() {
        return optimalTechLevel;
    }

    public int getPriceIncrese() {
        return priceIncrese;
    }

    public double getVariance() {
        return variance;
    }

    public RadicalEvent getRadicalPriceEvent() {
        return radicalPriceEvent;
    }

    public Resources getExpensivePrice() {
        return expensivePrice;
    }

    public Resources getCheapPrice() {
        return cheapPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMarketPrice(int marketPrice) {
        this.marketPrice = marketPrice;
    }
}
