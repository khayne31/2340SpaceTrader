package com.example.m5_projectsetupuserstoriesandconfiguration;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.GoodType;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Resources;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SolarSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TradeBuyTest {

    @Test public void noCreditsTest() {
        Player p1;
        p1 = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Boolean flag = true;
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO );


        Market market = new Market(dummyPlanet);
        p1.setCredits(0);
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals(testString,"You have no money to spend" );
    }
/*
    @Test public void outOfStockTest() {
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals(testString,"There are no items left to trade for" );
    }

    @Test public void insufficientItemsTest() {

        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals(testString,"There aren't enough of that good left to trade for");

    }

    @Test public void insufficientFundsTest() {
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals(testString,"You don't have enough credits to buy these items");
    }

    @Test public void insufficientSpaceTest() {
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals(testString,"You don't have enough cargo space left to store that good");
    }

    @Test public void successfulPurchaseTest() {
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals(testString,"The purchase was successful!");
    }

    @Test public void failedPurchaseTest() {
        String testString = market.tradeBuy(p1, GoodType.WATER, 1);
        assertEquals(testString,"The purchase failed");
    }

*/
}
