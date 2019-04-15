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

public class TradeSellTest {
    @Test
    public void noCargoTest() {
        Player p;
        p = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet", Resources.NO, Tech.PRE );


        Market market = new Market(dummyPlanet);
        p.getMyShip().setCargo(0);
        String testString = market.tradeSell(p, GoodType.WATER, 1);
        assertEquals("You have no items to sell" ,testString );
    }

    @Test public void outOfResourceTypeTest() {
        Player p;
        p = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);
        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO, Tech.HIT);


        Market market = new Market(dummyPlanet);
        p.getMyShip().addGood(GoodType.WATER, 0);
        p.getMyShip().addGood(GoodType.FOOD, 3);
        String testString = market.tradeSell(p, GoodType.WATER, 1);
        assertEquals("You have no items of that type to sell", testString );
    }


    @Test public void successfulSellTest() {
        Player p;
        p = new Player("TestPlayer", 4, 4, 4, 4, Difficulty.BE);

        Planet dummyPlanet;
        dummyPlanet = new Planet("DummyPlanet",Resources.NO , Tech.PRE);


        Market market = new Market(dummyPlanet);
        p.getMyShip().addGood(GoodType.WATER, 1);
        String testString = market.tradeSell(p, GoodType.WATER, 1);
        assertEquals("The sale was successful!",testString);
    }

}
