package com.example.m5_projectsetupuserstoriesandconfiguration;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;

import org.junit.Test;

import static org.junit.Assert.*;


//Author: Owen McCarty


public class LosePointsTest {
    private final int UNIVERSE_SIZE = 15;

    @Test
    public void LoseTest() {
        testingForPointsLost(new Player("name", 0, 0, 0, 0, Difficulty.BE, new Universe(UNIVERSE_SIZE)));
        testingForPointsLost(new Player("name", 1, 1, 1, 1, Difficulty.BE, new Universe(UNIVERSE_SIZE)));
        testingForPointsLost(new Player("name", 1, 2, 3, 4, Difficulty.BE, new Universe(UNIVERSE_SIZE)));
        testingForPointsLost(new Player("name", 2, 3, 4, 1, Difficulty.BE, new Universe(UNIVERSE_SIZE)));
        testingForPointsLost(new Player("name", 3, 4, 1, 2, Difficulty.BE, new Universe(UNIVERSE_SIZE)));
        testingForPointsLost(new Player("name", 4, 1, 2, 3, Difficulty.BE, new Universe(UNIVERSE_SIZE)));
    }

    public void testingForPointsLost(Player p) {
        assertNotNull(p.getFighterPoints());
        assertNotNull(p.getPilotPoints());
        assertNotNull(p.getEngineerPoints());
        assertNotNull(p.getTraderPoints());
        int fighterPoints = p.getFighterPoints();
        int engineerPoints = p.getEngineerPoints();
        int traderPoints = p.getTraderPoints();
        int pilotPoints = p.getPilotPoints();
        if ((p.getFighterPoints() == p.getEngineerPoints())
                && (p.getFighterPoints() == p.getTraderPoints())
                && (p.getFighterPoints() == p.getPilotPoints())) {
            p.losePoints(0);
            assertEquals(p.getEngineerPoints(), engineerPoints);
            p.losePoints(1);
            if (p.getEngineerPoints() != 0) {
                assertNotEquals(p.getEngineerPoints(), engineerPoints);
            }
        } else if ((p.getFighterPoints() > p.getEngineerPoints())
                && (p.getFighterPoints() > p.getTraderPoints())
                && (p.getFighterPoints() > p.getPilotPoints())) {
            p.losePoints(0);
            assertEquals(p.getFighterPoints(), fighterPoints);
            p.losePoints(1);
            if (p.getFighterPoints() != 0) {
                assertNotEquals(fighterPoints, p.getFighterPoints());
            }
            p.setFighterPoints(0);
            p.losePoints(1);
            assertNotEquals(p.getFighterPoints(), -1);
        } else if ((p.getEngineerPoints() > p.getFighterPoints())
                && (p.getEngineerPoints() > p.getTraderPoints())
                && (p.getEngineerPoints() > p.getPilotPoints())) {
            p.losePoints(0);
            assertEquals(p.getEngineerPoints(), engineerPoints);
            p.losePoints(1);
            if (p.getFighterPoints() != 0) {
                assertNotEquals(engineerPoints, p.getEngineerPoints());
            }
            p.setEngineerPoints(0);
            p.losePoints(1);
            assertNotEquals(p.getEngineerPoints(), -1);
        } else if ((p.getTraderPoints() > p.getFighterPoints())
                && (p.getTraderPoints() > p.getEngineerPoints())
                && (p.getTraderPoints() > p.getPilotPoints())) {
            p.losePoints(0);
            assertEquals(p.getTraderPoints(), traderPoints);
            p.losePoints(1);
            if (p.getTraderPoints() != 0) {
                assertNotEquals(traderPoints -1, p.getTraderPoints());
            }
            p.setTraderPoints(0);
            p.losePoints(1);
            assertNotEquals(p.getEngineerPoints(), -1);
        } else {
            p.losePoints(0);
            assertEquals(p.getPilotPoints(), pilotPoints);
            p.losePoints(1);
            if (p.getPilotPoints() != 0) {
                assertNotEquals(pilotPoints, p.getPilotPoints());
            }
            p.setPilotPoints(0);
            p.losePoints(1);
            assertNotEquals(p.getEngineerPoints(), -1);
        }

    }
}
