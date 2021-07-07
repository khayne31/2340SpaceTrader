package com.example.m5_projectsetupuserstoriesandconfiguration;

import org.junit.Test;

public class TestRunner {
    @Test
    public  void runAllTests(){
        UniverseTest();
        CoordinateSystemTest();
        PlanetTest();
        SolarSystemTest();
        RandomEventTest();
    }

    @Test
    public void UniverseTest(){
        new UniverseTest().testUniverse();
    }

    @Test
    public void CoordinateSystemTest(){
        new CoordinateSystemTest().CoordinateSystemTest();
    }

    @Test
    public void PlanetTest(){
        new PlanetTest().PlanetTest();
    }

    @Test
    public void SolarSystemTest(){
        new SolarSystemTest().SolarSystemTest();
    }
    @Test
    public   void RandomEventTest(){
        new RandomEventTest().RandomEventTest();
    }

}
