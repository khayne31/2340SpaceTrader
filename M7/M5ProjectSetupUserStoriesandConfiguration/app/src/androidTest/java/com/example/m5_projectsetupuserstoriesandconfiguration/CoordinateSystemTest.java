package com.example.m5_projectsetupuserstoriesandconfiguration;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.CoordinateSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Resources;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SolarSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class CoordinateSystemTest {
    @Test
    public static void CoordinateSystemTest(){
        int size = 10;
        int[] coords = new int[] {1,2};
        SolarSystem s  = new SolarSystem(size, coords);
        Resources r = Resources.MINPR;
        testCSVonstructor(Integer.MIN_VALUE, s, r);
        testCSVonstructor(Integer.MAX_VALUE, s, r);
        testCSVonstructor(Integer.MAX_VALUE, null, null);

    }
    private static void testCSVonstructor(int systemSize, SolarSystem s, Resources r){
        int size = systemSize;
        CoordinateSystem cs = new CoordinateSystem(size, s, r);
        assertEquals(cs.getSize(), size <= 0 ? Universe.MIN_SIZE: size);
        ArrayList<Planet> p = cs.getAllPlanets();
        assertNotEquals(p, null);
        int count = 0;
        for(int i=0; i < p.size(); i++){
            if(p.get(i) instanceof Planet)
                count++;
            assertNotEquals(p.get(i), null);
        }
        assertEquals(count, cs.getPlanetCounter());

    }
}
