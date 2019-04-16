package com.example.m5_projectsetupuserstoriesandconfiguration;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.GoodType;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Resources;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Tech;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A class that tests the tradeBuy method in the market class
 */
public class TradeBuyTest {

    /**
     * A test method that checks for proper method behavior when the Player has no credits
     */
    @Test public void noCreditsTest() {
        Player p1;
        p1 = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO, Tech.PRE );
        Market market = new Market(dummyPlanet);
        p1.setCredits(0);
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals("You have no money to spend",testString );
    }

    /**
     * A test method that checks for proper method behavior when the Market has none of the
     * requested item to trade for
     */
    @Test public void outOfStockTest() {
        Player p1;
        p1 = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO, Tech.HIT);
        Market market = new Market(dummyPlanet);
        market.updateSellList(GoodType.WATER, 0);
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals("There are no items left to trade for", testString );
    }

    /**
     * A test method that checks for proper method behavior when the Market has an insufficient
     * number of the requested item to trade for
     */
    @Test public void insufficientItemsTest() {

        Player p1;
        p1 = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO, Tech.HIT );
        Market market = new Market(dummyPlanet);
        market.updateSellList(GoodType.WATER, 1);
        String testString = market.tradeBuy(p1, GoodType.WATER, 2);
        assertEquals("There aren't enough of that good left to trade for", testString);

    }

    /**
     * A test method that checks for proper method behavior when the Player doesn't
     * have enough credits to buy something with
     */
    @Test public void insufficientFundsTest() {
        Player p1;
        p1 = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO, Tech.PRE );
        Market market = new Market(dummyPlanet);
        p1.setCredits(1);
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals("You don't have enough credits to buy these items",testString);
    }


    /**
     * A test method that checks for proper method behavior when the Player's Ship doesn't
     * have enough space to store the cargo you want to purchase
     */
    @Test public void insufficientSpaceTest() {
        Player p1;
        p1 = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO, Tech.PRE );
        Market market = new Market(dummyPlanet);
        p1.getMyShip().setCargo(20);
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals("You don't have enough cargo space left to store that good", testString);
    }

    /**
     * A test to check for a successful purchase of an item
     */
    @Test public void successfulPurchaseTest() {
        Player p1;
        p1 = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO , Tech.PRE);
        Market market = new Market(dummyPlanet);
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals("The purchase was successful!",testString);
    }
}
