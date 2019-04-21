package com.example.m5_projectsetupuserstoriesandconfiguration;


import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SolarSystem;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

/**
 * A test class for the Universe Constructor
 */
public class UniverseTest {
    /**
     * A test method for the universe constructor, contains multiple,
     * smaller tests
     */
    @Test
    public static void testUniverse(){
        Universe u1 = testingUniverseConstructor();
        //Universe u2 = testingUniverseConstructor(0);
        //Universe u3 = testingUniverseConstructor(Universe.MIN_SIZE);
        //Universe u4 = testingUniverseConstructor(14);
        //Universe u5 = testingUniverseConstructor(Universe.MAX_SIZE);
        //Universe u6 = testingUniverseConstructor(Integer.MAX_VALUE);


        testingUniverseConstructor(u1.getSystems(), Integer.MIN_VALUE);
        //testingUniverseConstructor(u2.getSystems(),0);
        //testingUniverseConstructor(u3.getSystems(),Universe.MIN_SIZE);
        //testingUniverseConstructor(u4.getSystems(),14);
        //testingUniverseConstructor(u5.getSystems(), Universe.MAX_SIZE);
        //testingUniverseConstructor(u6.getSystems(), Integer.MAX_VALUE);
    }

    private static Universe testingUniverseConstructor(){
        if(Integer.MIN_VALUE <= 0){
            Universe uni =  new Universe(Integer.MIN_VALUE);
            assertEquals(uni.getSizeOfUniverse(), Universe.MIN_SIZE);
            List<SolarSystem> s = uni.getSystems();
            List<ArrayList<SolarSystem>> u = uni.getUniverse();
            assertNotEquals(s, null);
            assertNotEquals(u, null);
            assertEquals(u.size(), Universe.MIN_SIZE);
            for(int i = 0; i < Universe.MIN_SIZE; i++){
                assertNotEquals(u.get(i), null);
                assertEquals(u.get(i).size(), Universe.MIN_SIZE);
            }

            for(int i=0; i < s.size(); i++){
                assertTrue(s.get(i) instanceof SolarSystem);
            }
            int count = 0;

            for(int i = 0; i < u.size(); i++){
                for(int j = 0; j < u.get(0).size(); j++){
                    if((u.get(i).get(j) != null) && (u.get(i).get(j) instanceof SolarSystem)){
                        count++;
                    }
                }
            }
            assertEquals(count, s.size());
            return uni;
        }
        else{
            int size = Integer.MIN_VALUE;
            Universe uni =  new Universe(size);
            assertEquals(uni.getSizeOfUniverse(), (size < Universe.MAX_SIZE) ? size : Universe.MAX_SIZE);
            size = (size > Universe.MAX_SIZE) ? Universe.MAX_SIZE : size;
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
                    if((u.get(i).get(j) != null) && (u.get(i).get(j) instanceof SolarSystem)){
                        count++;
                    }
                }
            }
            assertEquals(count, s.size() );
            return uni;
        }

    }

    private static void testingUniverseConstructor(ArrayList<SolarSystem> systems, int size){
        if(size <= 0){
            Universe uni =  new Universe(systems, size);
            assertEquals(uni.getSizeOfUniverse(), Universe.MIN_SIZE);
            List<SolarSystem> s = uni.getSystems();
            List<ArrayList<SolarSystem>> u = uni.getUniverse();
            assertNotEquals(s, null);
            assertNotEquals(u, null);
            assertEquals(u.size(), Universe.MIN_SIZE);
            assertArrayEquals(systems.toArray(), s.toArray());

            for(int i = 0; i < Universe.MIN_SIZE; i++){
                assertNotEquals(u.get(i), null);
                assertEquals(u.get(i).size(), Universe.MIN_SIZE);
            }

            for(int i=0; i < s.size(); i++){
                assertTrue(s.get(i) instanceof SolarSystem);
            }


            for(int i = 0; i < systems.size(); i++){
                SolarSystem currentSystem = systems.get(i);
                SolarSystem uniSystem = u.get(currentSystem.getCoords()[0]).get(currentSystem.getCoords()[1]);
                assertEquals(currentSystem, uniSystem);
            }
            int count = 0;

            for(int i = 0; i < u.size(); i++){
                for(int j = 0; j < u.get(0).size(); j++){
                    if((u.get(i).get(j) != null) && (u.get(i).get(j) instanceof SolarSystem)){
                        count++;
                    }
                }
            }
            assertEquals(count, s.size());
        }else{
            int sze = size;
            Universe uni =  new Universe(systems,sze);
            assertEquals(uni.getSizeOfUniverse(), (size < Universe.MAX_SIZE) ? size : Universe.MAX_SIZE);
            size = (size > Universe.MAX_SIZE) ? Universe.MAX_SIZE : size;
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


            for(int i = 0; i < systems.size(); i++){
                SolarSystem currentSystem = systems.get(i);
                SolarSystem uniSystem = u.get(currentSystem.getCoords()[0]).get(currentSystem.getCoords()[1]);
                assertEquals(currentSystem, uniSystem);
            }
            assertArrayEquals(systems.toArray(), s.toArray());

            int count = 0;

            for(int i = 0; i < u.size(); i++){
                for(int j = 0; j < u.get(0).size(); j++){
                    if((u.get(i).get(j) != null) && (u.get(i).get(j) instanceof SolarSystem)){
                        count++;
                    }
                }
            }
            assertEquals(count, s.size() );
        }

    }


}
