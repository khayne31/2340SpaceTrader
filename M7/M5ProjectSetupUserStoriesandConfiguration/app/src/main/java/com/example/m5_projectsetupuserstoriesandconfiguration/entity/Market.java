package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Market implements Serializable {
    private int marketSize;
    //first integer is number of goods second integer is price of goods
    private List<Item> itemSellList; // item {type, name, quantity, price}
    private Planet planet;
    private Player player;
    private int credits;
    private final int MIN_NUMBER_CREDITS = 100000;
    private final int MAX_MARKET_SIZE = 100;

    private final int QUANTITY_INDEX = 0;
    private final int PRICE_INDEX = 1;

    public Market(Planet planet){
        itemSellList = new ArrayList<Item>();
        marketSize = new Random().nextInt(MAX_MARKET_SIZE);
        this.planet = planet;
        //Get rid of this, market people don't need to have money
        credits = new Random().nextInt(MIN_NUMBER_CREDITS) + MIN_NUMBER_CREDITS;
        initializeMarketInventory();
        //Log.v("Test", "price: "+ goodList.get(GoodType.values()[0])[1]);
    }

    public Market(int marketSize, Planet planet, Player player) {
        this(planet);
        this.marketSize = marketSize;
        this.player = player;
    }

    private void initializeMarketInventory(){
        int remaingGoods = marketSize;
        //TODO fix this to make more balanced
        for(GoodType g : GoodType.values()) {

            //if the planet has the required tech level to sell a good, add it to the market
            if(planet.getT_lvl().getLvl() >= g.getMtlp()) {
                Random rand = new Random();
                int quant = rand.nextInt(remaingGoods+1);
                Log.d("MarketPrice", "Checkpoint-2");
                //int price = generateMarketPrice(g);
                Item i = new Item(g, g.getName(), quant, generateMarketPrice(g));
                itemSellList.add(i);
            } else {//else set the number of the good to zero in the item;
                Item i = new Item(g, g.getName(), 0, 0);
                itemSellList.add(i);
            }

        }
    }

    private int generateMarketPrice(GoodType gt){
        //may need to refine the event multiplier if its too difficult to put in UI
        int price = gt.getBasePrice();                         // set start price to be base price
        // this val will change according to multiplier
        double multiplier = 1;                                 // starts as 1, as if no effective events
        // won't affect price

        double variance = gt.getVar()/100.0 * gt.getBasePrice();  // the variance of price from base price (always
        // applied, kind of like a item tax)

        double techBal = (planet.getT_lvl().getLvl() - gt.getMtlp())/100.0 * gt.getBasePrice();
        // re-balance prices based on diff between planet tech and item tech production lvl
        // treat the diff as a percentage increase on base price
        // we don't have to worry about this being negative bc for the planet to sell the good
        // planet tech >= item tech so planet tech - item tech >= 0

        if( planet.getEvent().equals(gt.getIe()) ) {         // RadicalEvents match --> incr prices
            multiplier = multiplier * 1.5;
        }
//        if( planet.getResources().getResourceName().equals(gt.getCr().getResourceName()) ) {     // cheap resource condition
//             multiplier = multiplier * .5;
//        }
//        if( planet.getResources().getResourceName().equals(gt.getEr().getResourceName()) ) {     // expensive resource condition
//             multiplier = multiplier * 2;
//        }

        price = (int) ((double) price * multiplier + variance + techBal);   // use the price multiplier to accommodate event effects
        // add variance to price
        // add tech price re-balance
        return price;   // price is an int so we don't have to worry about awkward subtraction and partial credits

//        return  (int)(gt.getBasePrice() * ((planet.getEvent()).equals(gt.getEr()) ? gt.getBasePrice() : 1)
//                * (planet.getResources().equals(gt.getEr()) ? 2 : 1)
//                *  (planet.getResources().equals(gt.getCr()) ? .5 : 1)
//                + (Tech.values().length - gt.getMtlp())/(Tech.values().length + 0.0)
//                + gt.getVar()/100.0 * gt.getBasePrice());
    }
    public String tradeBuy(Player p, GoodType currentGood, int numberOfGood){
        String returnString;
        int position = getTradeGoodPosition(currentGood);
        if(p.getCredits() <= 0){
            returnString = "You have no money to spend";
        } else if(itemSellList.get(position).getQuantity() == 0){
            returnString = "There is no items left to trade for";
        } else if(itemSellList.get(position).getQuantity() < numberOfGood){
            returnString = "There aren't enough of that good left to trade for";
        }  else if(p.getCredits() < itemSellList.get(position).getPrice() * numberOfGood){
            returnString = "You don't have enough credits to buy these items";
        } else if ((p.getMyShip().getCurrCargoSize() + numberOfGood) > p.getMyShip().getType().getMaxCargo()) {
            returnString = "You don't have enough cargo space left to store that good";
        }else{

            Item updateItem = itemSellList.get(position);

            if (p.getMyShip().addGood(updateItem.getType(), numberOfGood)){
                updateItem.sellQuantity(numberOfGood);
                itemSellList.set(position, updateItem);
                returnString = "The purchase was successful!";
                int moneyTraded =  numberOfGood * updateItem.getPrice();
                p.setCredits(p.getCredits() - moneyTraded);
                //deprecated
                credits += moneyTraded;
            } else{
                returnString = "The purchase failed";
            }

        }
        return returnString;
    }

    public String tradeSell(Player p, GoodType currentGood, int numberOfGood){

        //deprecated
        List<Item> buyItems = getBuyItems(p);
        int position = getTradeGoodPosition(currentGood);

        String returnString;
        if(p.getMyShip().getCurrCargoSize() == 0){
            returnString = "You have no items to sell";
        } else if(p.getMyShip().getGoodList().get(currentGood) == 0){
            returnString = "You have no items of that type to sell";
        } else{
            if (p.getMyShip().sellGood(currentGood, numberOfGood)){
                returnString = "The sale was successful!";
                int moneyTraded =  numberOfGood * getTradeGoodPrice(currentGood);
                credits -= moneyTraded;
                Item updateItem = itemSellList.get(position);
                int currentQuantity = updateItem.getQuantity();
                updateItem.setQuantity(currentQuantity + numberOfGood);
                itemSellList.set(position, updateItem);
                p.setCredits(p.getCredits() + moneyTraded);
            } else {
                returnString = "The sale was unsuccessful";
            }


        }
        return returnString;
    }

    // get list of items that are available in the market (aka sell quantity > 0)
    public List<Item> getSellItems() { return itemSellList; }

    // get list of items that player has
    //deprecate
    public List<Item> getBuyItems(Player p) {
        List<Item> itemBuyList = new ArrayList<>();

        for(GoodType g : p.getMyShip().getGoodList().keySet()) {
            GoodType type = g;
            String name = g.getName();
            int quant = p.getMyShip().getGoodList().get(g); // gets the quantity owned
            //This is the problem line, below (now fixed)
            int price = getTradeGoodPrice(g);
            Item i = new Item(g, g.getName(), quant, price);
            itemBuyList.add(i);
        }
        return itemBuyList;
    }

    public int getTradeGoodQuantity(GoodType currentGood) {
        for (Item item : itemSellList) {
            if (item.getType() == currentGood) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public int getTradeGoodPrice(GoodType currentGood) {
        for (Item item : itemSellList) {
            if (item.getType() == currentGood) {
                return item.getPrice();
            }
        }
        return 0;
    }

    public int getTradeGoodPosition(GoodType currentGood) {
        int positionCount = 0;
        for (Item item : itemSellList) {
            if (item.getType() == currentGood) {
                return positionCount;
            }
            positionCount++;
        }
        return positionCount;


    }

}