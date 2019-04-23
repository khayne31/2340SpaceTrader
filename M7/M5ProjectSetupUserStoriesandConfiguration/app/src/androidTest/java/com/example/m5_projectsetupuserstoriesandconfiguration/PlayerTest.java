package com.example.m5_projectsetupuserstoriesandconfiguration;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;
import com.example.m5_projectsetupuserstoriesandconfiguration.views.MainActivity;

import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {
    @Test
    public void PlayerTest(){
        Universe uni = new Universe(Universe.MIN_SIZE);
        testConstructor("hi", 10,2,3,1, Difficulty.NO, uni);
        testConstructor(null, -1,-2,-3,-4, null, null);
        testConstructor("testing", 1,2,3,0, null, uni);

    }

    private void testConstructor(String name, int fPoints, int tPoints, int ePoints, int pPoints,
                                 Difficulty difficulty, Universe uni){
        Player p1 = new Player(name, fPoints, tPoints, ePoints, pPoints,difficulty);
        assertTrue(p1.getFighterPoints() >= 0 && p1.getFighterPoints() <= p1.getMax_pts());
        assertTrue(p1.getEngineerPoints() >= 0 && p1.getEngineerPoints() <= p1.getMax_pts());
        assertTrue(p1.getTraderPoints() >= 0 && p1.getTraderPoints() <= p1.getMax_pts());
        assertTrue(p1.getPilotPoints() >= 0 && p1.getPilotPoints() <= p1.getMax_pts());
        Log.d("playertests", p1.getEngineerPoints() + " "
        + p1.getTraderPoints() + " " + p1.getFighterPoints() + " " + p1.getPilotPoints() );
        assertEquals(p1.getMax_pts(), p1.getEngineerPoints()
                + p1.getFighterPoints() + p1.getPilotPoints() + p1.getTraderPoints());
        if(difficulty != null)
            assertEquals(difficulty, p1.getDiff());
        assertNotEquals(null, p1.getMyShip());
        assertTrue(p1.getInitalHp() > 0);
        assertNotEquals(null, p1.getCurrentUniverse());
        assertNotEquals(null, p1.getCurrentSystem());
        assertNotEquals(null, p1.getCurrentSystem());
        assertNotEquals(null, p1.getName());
        boolean sum = fPoints + ePoints + tPoints + pPoints == p1.getMax_pts();
        if(fPoints >= 0 && fPoints <= p1.getMax_pts() && sum)
            assertEquals(fPoints, p1.getFighterPoints());
        if(tPoints >= 0 && tPoints <= p1.getMax_pts() && sum)
            assertEquals(tPoints, p1.getTraderPoints());
        if(ePoints >= 0 && ePoints <= p1.getMax_pts() && sum)
            assertEquals(ePoints, p1.getEngineerPoints());
        if(pPoints >= 0 && pPoints <=p1.getMax_pts() && sum)
            assertEquals(pPoints, p1.getPilotPoints());


        p1 = new Player(name, fPoints, tPoints, ePoints, pPoints,difficulty, uni);
        assertTrue(p1.getFighterPoints() >= 0 && p1.getFighterPoints() < p1.getMax_pts());
        assertTrue(p1.getEngineerPoints() >= 0 && p1.getEngineerPoints() < p1.getMax_pts());
        assertTrue(p1.getTraderPoints() >= 0 && p1.getTraderPoints() < p1.getMax_pts());
        assertTrue(p1.getPilotPoints() >= 0 && p1.getPilotPoints() < p1.getMax_pts());
        assertEquals(p1.getMax_pts(), p1.getEngineerPoints()
                + p1.getFighterPoints() + p1.getPilotPoints() + p1.getTraderPoints());
        if(difficulty != null)
            assertEquals(difficulty, p1.getDiff());
        assertNotEquals(null, p1.getMyShip());
        assertTrue(p1.getInitalHp() > 0);
        assertNotEquals(null, p1.getCurrentUniverse());
        assertNotEquals(null, p1.getCurrentSystem());
        assertNotEquals(null, p1.getCurrentSystem());
        assertNotEquals(null, p1.getName());
        if(uni != null)
            assertEquals(uni, p1.getCurrentUniverse());
        if(fPoints >= 0 && fPoints <= p1.getMax_pts() && sum)
            assertEquals(fPoints, p1.getFighterPoints());
        if(tPoints >= 0 && tPoints <= p1.getMax_pts() && sum)
            assertEquals(tPoints, p1.getTraderPoints());
        if(ePoints >= 0 && ePoints <= p1.getMax_pts() && sum)
            assertEquals(ePoints, p1.getEngineerPoints());
        if(pPoints >= 0 && pPoints <= p1.getMax_pts() && sum)
            assertEquals(pPoints, p1.getPilotPoints());

    }



}
