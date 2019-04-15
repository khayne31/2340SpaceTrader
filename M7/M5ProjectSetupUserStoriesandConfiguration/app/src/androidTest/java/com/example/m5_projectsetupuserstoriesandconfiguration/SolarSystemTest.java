package com.example.m5_projectsetupuserstoriesandconfiguration;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SolarSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

class SolarSystemTest {

    @Test
    public void SolarSystemTest(){
        testingSolarSystemConstructor(Integer.MIN_VALUE, new int[] {});
        testingSolarSystemConstructor(Integer.MAX_VALUE, new int[] {});
        int[] inputArray = new int[100];
        for(int i = 1; i <= 100; i++){
            inputArray[i] = (int)Math.pow(-1, i) * i;
        }
        testingSolarSystemConstructor(Integer.MAX_VALUE, inputArray);
        testingSolarSystemConstructor(Integer.MIN_VALUE, inputArray);
        inputArray[0] = Integer.MIN_VALUE;
        inputArray[1] = Integer.MAX_VALUE;
        testingSolarSystemConstructor(Universe.MAX_SIZE, inputArray);
        testingSolarSystemConstructor(Universe.MIN_SIZE, inputArray);

    }
    private void testingSolarSystemConstructor(int size, int[] coords){

        SolarSystem s = new SolarSystem(size, coords);
        if(coords.length < 2){
            assertEquals(s.getCoords(), new int[] {0,0});
            assertTrue(s.getCoords()[0] >= 0);
            assertTrue(s.getCoords()[1] >= 1);
        } else{
            assertEquals(s.getCoords(), new int[]{Math.abs(coords[0]), Math.abs(coords[1])});
            assertTrue(s.getCoords()[0] >= 0);
            assertTrue(s.getCoords()[1] >= 1);
        }
        assertNotEquals(s.getSystemName(), null);


    }
}
