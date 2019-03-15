package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

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
        //initializeHashTable();
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
            if(planet.getT_lvl().getLvl() >= g.getMtlp()) {
                Random rand = new Random();
                int quant = rand.nextInt(remaingGoods+1);
                Item i = new Item(g, g.getName(), quant, generateMarketPrice(g));
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
    }

    public void tradeBuy(Player p, int position, int numberOfGood){
        if(p.getCredits() <= 0){
            //TODO make it so there is ome message displayed which states they have no money to spend
        } else if(itemSellList.get(position).getQuantity() == 0){
            //TODO make it so there is a message which states there is none of the item to trade
        } else if(itemSellList.get(position).getQuantity() < numberOfGood){
            //TODO make it so there is a message which states that that there aren't numberOfGoods goods left
        }  else if(p.getCredits() < itemSellList.get(position).getPrice() * numberOfGood){
            //TODO make it so there is a message which states you don't have enough credits to buy numberOfGoods goods
        } else{
            Item updateItem = itemSellList.get(position);
            updateItem.sellQuantity(numberOfGood);

            itemSellList.set(position, updateItem);

            if (p.getMyShip().addGood(updateItem.getType(), numberOfGood)){
                //TODO display a message that says the trade was sucessful
                int moneyTraded =  numberOfGood * updateItem.getPrice();
                p.setCredits(p.getCredits() - moneyTraded);
                credits += moneyTraded;
            } else{
                //TODO display a message which says the trade failed
            }

        }
    }

    public void tradeSell(Player p, int position, int numberOfGood){
        List<Item> buyItems = getBuyItems(p);
        if(p.getMyShip().getCurrCargoSize() == 0){
            //TODO make it so there is a message which states the cargo has no goods in it period
        } else if(p.getMyShip().getGoodList().get(buyItems.get(position).getType()) == 0){
            //TODO make it so there is a message which states that the ship has none of the good in the cargo
        } else{
            if (p.getMyShip().sellGood(buyItems.get(position).getType(), numberOfGood)){
                //TODO display a message that says the trade was sucessful
                int moneyTraded =  numberOfGood * buyItems.get(position).getPrice();
                credits -= moneyTraded;
                p.setCredits(p.getCredits() + moneyTraded);
            } else{
                //TODO display a message which says the trade failed
            }


        }
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

}