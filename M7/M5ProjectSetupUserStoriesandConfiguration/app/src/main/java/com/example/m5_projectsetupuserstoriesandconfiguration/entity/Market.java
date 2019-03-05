package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Market {
    private int marketSize;
    //first integer is number of goods second integer is price of goods
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
        int remaingGoods = marketSize;
        //TODO fix this to make more balanced
        for(int i = 0 ; i < 10; i++){
            double prob = Math.random();
            int numberWhichRemain = (int)(remaingGoods * (prob < .5 ? (1-prob)*.5 + prob : prob));
            goodList.put(GoodType.values()[i],new Integer[] {remaingGoods - numberWhichRemain, generateMarketPrice(GoodType.values()[i])});
            remaingGoods = numberWhichRemain;
        }
    }

   private int generateMarketPrice(GoodType gt){
        //may need to refine the event multiplier if its too difficult to put in UI
        return  (int)(gt.getBasePrice() * (planet.getEvent().equals(gt.getEr()) ? gt.getBasePrice() : 1)
                * (planet.getResources().equals(gt.getEr()) ? 2 : 1)
                *  (planet.getResources().equals(gt.getCr()) ? 2 : 1)
                + (7 - gt.getMtlp())/(8.0) + gt.getVar()/100.0 * gt.getBasePrice());
   }

   public void tradeBuy(Player p, GoodType g, int numberOfGood){
        if(p.getCredits() <= 0){
            //TODO make it so there is ome message displayed which states they have no money to spend
        } else if(goodList.get(g)[0] == 0){
                //TODO make it so there is a message which states there is none of the item to trade
        } else if(goodList.get(g)[0] < numberOfGood){
                //TODO make it so there is a message which states that that there arnt numberOfGoods goods left
        } else if(p.getMyShip().getCurrCargoSize() == 0){
                //TODO make it so there is a message which states the cargo has no goods in it period
        } else if(p.getMyShip().getGoodList().get(g) == 0){
                //TODO make it so there is a message which states that the ship has none of the good in the cargo
        } else if(p.getCredits() < goodList.get(g)[1] * numberOfGood){
                //TODO make it so there is a message which states you don't have enough credits to buy numberOfGoods goods
        } else{
            p.setCredits(p.getCredits() - numberOfGood * goodList.get(g)[1]);
            goodList.put(g, new Integer[]{goodList.get(g)[0] - numberOfGood, goodList.get(g)[1]});
            if (p.getMyShip().addGood(g, numberOfGood)){
                //TODO display a message that says the trade was sucessful
            } else{
                //TODO display a message which says the trade failed
            }

        }
}

}
