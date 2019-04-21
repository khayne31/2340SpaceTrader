package com.example.m5_projectsetupuserstoriesandconfiguration;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.CoordinateSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SolarSystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class PlanetTest {
    @Test
    public void PlanetTest(){
        int size = 15;
        int[] coords = new int[] {1,2};
        SolarSystem s  = new SolarSystem(size, coords);
        CoordinateSystem cs = s.getCoordinateSystem();
        String name = s.getSystemName();
        testingPlanetConstuctor(name, s, cs);
    }

    private void testingPlanetConstuctor(String str, SolarSystem s, CoordinateSystem cs){
        Planet p = new Planet(new int[] {0,0}, str, s, s.getResource());
        Log.d("punit", p.getName());
        Log.d("punit", s.getSystemName());
        Log.d("punit", cs.getSystemName());
        assertEquals(s.getSystemName(), p.getName());
        assertEquals(cs.getSystemName(), p.getName());
        assertEquals(p.getResources(), s.getResource());
        assertNotEquals(p.getT_lvl(), null);
        Market oldmarket = p.getMarket();
        assertNotEquals(oldmarket, null);
        p.playerLandedOn();
        assertNotEquals(oldmarket, p.getMarket());
        assertEquals(p.getHomesystem(), s);

        p = new Planet(str, s.getResource(), s.getTech());
        assertNotEquals(p.getT_lvl(), s.getTech());
        assertEquals(s.getSystemName(), p.getName());
        assertEquals(cs.getSystemName(), p.getName());
        assertEquals(p.getResources(), s.getResource());
        assertNotEquals(p.getT_lvl(), null);
        oldmarket = p.getMarket();
        assertNotEquals(null, oldmarket);
        p.playerLandedOn();
        assertNotEquals(oldmarket, p.getMarket());


    }
}
