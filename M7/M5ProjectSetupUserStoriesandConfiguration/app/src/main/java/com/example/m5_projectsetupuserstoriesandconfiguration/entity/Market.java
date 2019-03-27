package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Market {
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
        credits = new Random().nextInt(MIN_NUMBER_CREDITS) + MIN_NUMBER_CREDITS;
        Log.d("MarketTest", "We made it this far!");
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
            Log.d("MarketTest", "We made it this far! 1");



            //if the planet has the required tech level to sell a good, add it to the market
            if(planet.getT_lvl().getLvl() >= g.getMtlp()) {
                Random rand = new Random();
                int quant = rand.nextInt(remaingGoods+1);
                Item i = new Item(g, g.getName(), quant, 1);//generateMarketPrice(g));
                itemSellList.add(i);
            } else {//else set the number of the good to zero in the item;
                Item i = new Item(g, g.getName(), 0, 0);
                itemSellList.add(i);
            }

        }
    }

    private int generateMarketPrice(GoodType gt){
        //may need to refine the event multiplier if its too difficult to put in UI

        return  (int)(gt.getBasePrice() * (planet.getEvent().equals(gt.getEr()) ? gt.getBasePrice() : 1)
                * (planet.getResources().equals(gt.getEr()) ? 2 : 1)
                *  (planet.getResources().equals(gt.getCr()) ? .5 : 1)
                + (Tech.values().length - gt.getMtlp())/(Tech.values().length + 0.0)
                + gt.getVar()/100.0 * gt.getBasePrice());
        //I am rewriting the above code because it has no documentation
        /*int basePrice = gt.getBasePrice();
        int eventMultiplier;
        int resourceMultiplier1;
        int resourceMultiplier2;
        int finalPrice;
        return 1;*/




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
        } else{
            Item updateItem = itemSellList.get(position);
            updateItem.sellQuantity(numberOfGood);

            itemSellList.set(position, updateItem);

            if (p.getMyShip().addGood(updateItem.getType(), numberOfGood)){
                returnString = "The purchase was successful!";
                int moneyTraded =  numberOfGood * updateItem.getPrice();
                p.setCredits(p.getCredits() - moneyTraded);
                credits += moneyTraded;
            } else{
                returnString = "The purchase failed";
            }

        }
        return returnString;
    }

    public String tradeSell(Player p, GoodType currentGood, int numberOfGood){
        List<Item> buyItems = getBuyItems(p);
        int position = getTradeGoodPosition(currentGood);
        String returnString;
        if(p.getMyShip().getCurrCargoSize() == 0){
            returnString = "You have no items to sell";
        } else if(p.getMyShip().getGoodList().get(buyItems.get(position).getType()) == 0){
            returnString = "You have no items of that type to sell";
        } else{
            if (p.getMyShip().sellGood(buyItems.get(position).getType(), numberOfGood)){
                returnString = "The sale was successful!";
                int moneyTraded =  numberOfGood * buyItems.get(position).getPrice();
                credits -= moneyTraded;
                p.setCredits(p.getCredits() + moneyTraded);
            } else{
                returnString = "The sale was unsuccessful";
            }


        }
        return returnString;
    }

    // get list of items that are available in the market (aka sell quantity > 0)
    public List<Item> getSellItems() { return itemSellList; }

    // get list of items that player has
    public List<Item> getBuyItems(Player p) {
        List<Item> itemBuyList = new ArrayList<>();

        for(GoodType g : p.getMyShip().getGoodList().keySet()) {
            // type = g
            // name = g.getName
            int quant = p.getMyShip().getGoodList().get(g); // gets the quantity owned
            int price = generateMarketPrice(g);
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