package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Market {
    private int marketSize;
    private Hashtable<GoodType, Integer[]> goodList;
    private Planet planet;

    public Market(Planet planet){
        goodList = new Hashtable<>();
        marketSize = new Random().nextInt(100);
        this.planet = planet;
    }

    public Market(int marketSize, Planet planet) {
        this(planet);
        this.marketSize = marketSize ;
    }

    private void initializeHashTable(){
//        goodList.put(GoodType.values()[0], 0);
//        goodList.put(GoodType.values()[1], 0);
//        goodList.put(GoodType.values()[2], 0);
//        goodList.put(GoodType.values()[3], 0);
//        goodList.put(GoodType.values()[4], 0);
//        goodList.put(GoodType.values()[5], 0);
//        goodList.put(GoodType.values()[6], 0);
//        goodList.put(GoodType.values()[7], 0);
//        goodList.put(GoodType.values()[8], 0);
//        goodList.put(GoodType.values()[9], 0);
        int remaingGoods = marketSize;
        //TODO fix this to make more balanced
        for(int i = 0 ; i < 10; i++){
            int takeawayValue = (int)(remaingGoods * new Random().nextGaussian());
            goodList.put(GoodType.values()[i],new Integer[] {takeawayValue, generateMarketPrice(GoodType.values()[i])});
            remaingGoods -= takeawayValue;
        }
    }

   private int generateMarketPrice(GoodType gt){
        //may need to refine the event multiplier if its too difficult to put in UI
        return  (int)(gt.getBasePrice() * (planet.getEvent().equals(gt.getEr()) ? gt.getBasePrice() : 1)
                * (planet.getResources().equals(gt.getEr()) ? 2 : 1)
                *  (planet.getResources().equals(gt.getCr()) ? 2 : 1)
                + (7 - gt.getMtlp())/(8.0) + gt.getVar()/100.0 * gt.getBasePrice());

   }

}
