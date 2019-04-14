package com.example.m5_projectsetupuserstoriesandconfiguration;


import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SolarSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

public class UniverseTest {
    @Test
    public void testUniverse(){
        testingUniverseConstructor(-10);
        testingUniverseConstructor(0);
        testingUniverseConstructor(20);
    }

    public void testingUniverseConstructor(int sze){
        if(sze <= 0){
            int size = sze;
            Universe uni =  new Universe(size);
            assertEquals(uni.getSizeOfUniverse(), 10);
            ArrayList<SolarSystem> s = uni.getSystems();
            List<ArrayList<SolarSystem>> u = uni.getUniverse();
            assertNotEquals(s, null);
            assertNotEquals(u, null);
            assertEquals(u.size(), 10);
            for(int i = 0; i < 10; i++){
                assertNotEquals(u.get(i), null);
                assertEquals(u.get(i).size(), 10);
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
            assertEquals(uni.getSizeOfUniverse(), size);
            ArrayList<SolarSystem> s = uni.getSystems();
            List<ArrayList<SolarSystem>> u = uni.getUniverse();
            assertNotEquals(s, null);
            assertNotEquals(u, null);
            assertEquals(u.size(), size);
            for(int i = 0; i < 10; i++){
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
