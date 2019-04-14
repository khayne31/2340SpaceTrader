package com.example.m5_projectsetupuserstoriesandconfiguration;


import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SolarSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

public class UniverseTest {
    private final int size14 = 14;
    private final int size20 = 20;
    @Test
    public void testUniverse(){
        testingUniverseConstructor(Integer.MIN_VALUE);
        testingUniverseConstructor(0);
        testingUniverseConstructor(10);
        testingUniverseConstructor(size14);
        testingUniverseConstructor(size20);
        testingUniverseConstructor(Integer.MAX_VALUE);
    }

    private void testingUniverseConstructor(int sze){
        if(sze <= 0){
            int size = sze;
            Universe uni =  new Universe(size);
            assertEquals(uni.getSizeOfUniverse(), uni.MIN_SIZE);
            List<SolarSystem> s = uni.getSystems();
            List<ArrayList<SolarSystem>> u = uni.getUniverse();
            assertNotEquals(s, null);
            assertNotEquals(u, null);
            assertEquals(u.size(), uni.MIN_SIZE);
            for(int i = 0; i < 10; i++){
                assertNotEquals(u.get(i), null);
                assertEquals(u.get(i).size(), uni.MIN_SIZE);
            }

            for(int i=0; i < s.size(); i++){
                assertTrue(s.get(i) instanceof SolarSystem);
            }
            int count = 0;

            for(int i = 0; i < u.size(); i++){
                for(int j = 0; j < u.get(0).size(); j++){
                    if(u.get(i).get(j) != null && u.get(i).get(j) instanceof SolarSystem){
                        count++;
                    }
                }
            }
            assertEquals(count, s.size());
        }
        else{
            int size = sze;
            Universe uni =  new Universe(size);
            assertEquals(uni.getSizeOfUniverse(), size < uni.MAX_SIZE ? size: uni.MAX_SIZE);
            size = size > uni.MAX_SIZE ? uni.MAX_SIZE : size ;
            List<SolarSystem> s = uni.getSystems();
            List<ArrayList<SolarSystem>> u = uni.getUniverse();
            assertNotEquals(s, null);
            assertNotEquals(u, null);
            assertEquals(u.size(), size);
            for(int i = 0; i < size; i++){
                assertNotEquals(u.get(i), null);
                assertEquals(u.get(i).size(), size);
            }

            for(int i=0; i < s.size(); i++){
                assertTrue(s.get(i) instanceof SolarSystem);
            }
            int count = 0;

            for(int i = 0; i < u.size(); i++){
                for(int j = 0; j < u.get(0).size(); j++){
                    if(u.get(i).get(j) != null && u.get(i).get(j) instanceof SolarSystem){
                        count++;
                    }
                }
            }
            assertEquals(count, s.size() );
        }

    }

}
