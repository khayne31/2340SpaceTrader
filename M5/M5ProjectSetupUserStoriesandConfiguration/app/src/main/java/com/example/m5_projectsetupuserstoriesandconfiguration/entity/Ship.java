package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class Ship {
    private enum  shipType {
        FL("Flea", "FL", 7, 20), // cargoSize not given (on wiki) supposed to be "few"
        GN("Gnat", "GN", 15, 14),
        FI("Firefly", "FI", 20, 17),
        MO("Mosquito", "MO", 15, 13),
        BB("Bumblebee", "BB", 20, 15),
        BE("Beetle", "BE", 50, 14),
        HO("Hornet", "HO", 20, 16),
        GR("Grasshopper", "GR", 30, 15),
        TE("Termite", "TE", 60, 13),
        WA("Wasp", "WA", 35, 14);

        private final String type;
        private final String id;
        private final int cargoSize;
        private final int range;

        shipType(String sType, String sId, int cSize, int r) {
            type = sType;
            id = sId;
            cargoSize = cSize;
            range = r;
        }
    }



}
