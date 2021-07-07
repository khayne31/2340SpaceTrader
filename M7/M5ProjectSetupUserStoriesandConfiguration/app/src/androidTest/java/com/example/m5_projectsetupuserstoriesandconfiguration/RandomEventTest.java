package com.example.m5_projectsetupuserstoriesandconfiguration;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.RandomEvent;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Ship;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;


/**
 * A test class that checks if Random events work properly
 */
public class RandomEventTest {
    @Test
    public void RandomEventTest(){
        Universe u = new Universe(Universe.MIN_SIZE);
        Player p = new Player("Test Player", 500,500,500,
                500, Difficulty.NO, u);
        RandomEvent r = new RandomEvent();
        RandomEvent.events e;
        RandomEvent.events[] a = RandomEvent.events.values();
        ArrayList<RandomEvent.events> al = new ArrayList<>(Arrays.asList(a));
        Planet originaPlanet = p.getCurrentPlanet();
        int orginalCredits = p.getCredits();
        Ship originalShip = p.getMyShip();
        Ship.shipType originalShipType = originalShip.getType();
        int originalFuel = originalShip.getFuel();
        int originalHp = originalShip.getHp();
        int index;
        int count = 0;

        for(int i = 0; i < a.length * 1.5; i++){
            e  = RandomEvent.events.values()[new Random().nextInt(RandomEvent.events.values().length-1)];
            assertNotEquals(e, null);
        }
        for(int i = 0; i < a.length ; i++){
            RandomEvent.generateSpecifiedEvent(a[i], p);
        }
        Log.d("junit1", originalShip.getType().toString() + "new : " + p.getMyShip().getType().toString());
        assertNotEquals(originaPlanet, p.getCurrentPlanet());
        assertNotEquals(originalShipType, p.getMyShip().getType());
        assertNotEquals(originalFuel, p.getMyShip().getFuel());
        assertNotEquals(originalHp, p.getMyShip().getHp());
        assertNotEquals(orginalCredits, p.getCredits());

    }

}
