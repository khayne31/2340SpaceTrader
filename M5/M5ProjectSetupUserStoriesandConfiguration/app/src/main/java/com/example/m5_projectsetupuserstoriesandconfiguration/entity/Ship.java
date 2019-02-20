package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class Ship {
    private enum shipType {
        //(Name, ID, cargo, range, hull, crew, wp, gad, sh)
        FL("Flea", "FL", 7, 20, 10, 0, 0, 0, 0), // cargoSize not given (on wiki) supposed to be "few"
        GN("Gnat", "GN", 15, 14, 20, 0, 1, 1, 0),
        FI("Firefly", "FI", 20, 17, 25, 0, 1, 1, 1),
        MO("Mosquito", "MO", 15, 13, 30, 0, 2, 1, 1),
        BB("Bumblebee", "BB", 20, 15, 25, 1, 1, 2, 2),
        BE("Beetle", "BE", 50, 14, 10, 3, 0, 1, 1),
        HO("Hornet", "HO", 20, 16, 30, 2, 3, 1, 2),
        GR("Grasshopper", "GR", 30, 15, 35, 3, 2, 3, 2),
        TE("Termite", "TE", 60, 13, 50, 3, 1, 2, 3),
        WA("Wasp", "WA", 35, 14, 50, 3, 3, 2, 2);

        private final String type;
        private final String id;
        private final int cargoSize;
        private final int range;
        private final int hullStrength;
        private final int crewSize;
        private final int wpSlots;
        private final int gadSlots;
        private final int shSlots;

        // need hullStrength, crewSize, wpSlots, gadSlots, shSlots

        shipType(String sType, String sId, int cSize, int r, int hull, int crew, int wp, int gad, int sh) {
            type = sType;
            id = sId;
            cargoSize = cSize;
            range = r;
            hullStrength = hull;
            crewSize = crew;
            wpSlots = wp;
            gadSlots = gad;
            shSlots = sh;
        }
    }

    private enum weaponType {
        PL("Pulse Lasers", "PL", 1),
        BL("Beam Lasers", "BL", 5),
        ML("Military Lassers", "ML", 10);

        private final String type;
        private final String id;
        private final int dmg;

        weaponType(String wType, String wID, int wDMG) {
            type = wType;
            id = wID;
            dmg = wDMG;
        }
    }

    private enum shieldType {
        ES("Energy Shields", "ES", 10, 0),
        RS("Reflective Shields", "RS", 20, 5);

        private final String type;
        private final String id;
        private final int sp;                   // sp = shield power
        private final int dmg;

        shieldType(String sType, String sID, int sPower, int sDMG) {
            type = sType;
            id = sID;
            sp = sPower;
            dmg = sDMG;
        }
    }

    private enum gadgetType {
        CB("Extra Cargo Bays (5)", "CB"),
        NS("Navigation System", "NS"),
        AS("Auto-Repair System", "AS"),
        TS("Targeting System", "TS"),
        CD("Cloaking Device", "CD");

        private final String type;
        private final String id;

        gadgetType(String gType, String gID) {
            type = gType;
            id = gID;
        }
    }

    private shipType type;
    private int fuel;
    private int hp;


    public Ship(shipType type, int fuel, int hp) {
        this.type = type;
        this.fuel = fuel;
        this.hp = hp;
    }
}
