package com.example.m5_projectsetupuserstoriesandconfiguration;

import org.junit.Test;

public class TestRunner {
    @Test
    public static void runAllTests(){
        UniverseTest.testUniverse();
        PlanetTest.PlanetTest();
        CoordinateSystemTest.CoordinateSystemTest();
        SolarSystemTest.SolarSystemTest();
    }



    public static void main(String[] args){
        runAllTests();
    }
}
