package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 * The solarsystem class
 */
public class SolarSystem implements Serializable {
    private final ArrayList<Planet> planets;
    private final int systemSize;
    private final String systemName;
    private int[] coords;
    private final Governments gov;
    private final Tech tech;
    private Resources resource;

    /**
     * The constructor for the SolarSystem class
     * @param size the size of a size of the SolarSystem
     * @param coordinates an array containing the position of the system in the Universe
     */
    public  SolarSystem(int size, int[] coordinates) {
        coords = new int[2];
        if (size <= Universe.MIN_SIZE) {
            systemSize = Universe.MIN_SIZE;
        } else if (size >= Universe.MAX_SIZE) {
            systemSize = Universe.MAX_SIZE;
        } else {
            systemSize = size;
        }

        systemName = generateRandomName();
        CoordinateSystem system = new CoordinateSystem(systemSize, this, resource);


        planets = system.getAllPlanets();

        if (coordinates.length >= 2) {
            coords[0] = coordinates[0] >= 0 ? coordinates[0] : Math.abs(coordinates[0]);
            coords[1] = coordinates[1] >= 0 ? coordinates[1] : Math.abs(coordinates[1]) ;
            //coords = coordinates;
            Log.d("UniverseLogCat", "inside solar system constructor coords: "
                    + coordinates[0] + " " + coordinates[1]);
        /*if(coordinates.length == 2){
            coords[0] = coordinates[0] >= 0 ? coordinates[0] : Math.abs(coordinates[0]);
            coords[1] = coordinates[1] >= 0 ? coordinates[1] : Math.abs(coordinates[1]) ;
            Log.d("UniverseLogCat", "inside solar system constructor coords: "
                    + coordinates[0] + " "+ coordinates[1]);
        } */

//        } else if(coordinates.length > 2){
//            //coords[0] = coordinates[0] >= 0 ? coordinates[0] : Math.abs(coordinates[0]);
//            coords[1] = coordinates[1] >= 0 ? coordinates[1] : Math.abs(coordinates[1]) ;
//        }
            }
            else {
                coords = new int[]{0, 0};
            }
            gov = Governments.values()[new Random().nextInt(Governments.values().length)];
            tech = Tech.values()[new Random().nextInt(Tech.values().length)];
            resource = Resources.values()[new Random().nextInt(Resources.values().length)];
        }


    /**
     * A solarsystem constructor used for testing the market class
     *
     * @param name The name of the new system
     */
    public SolarSystem(String name) {
        gov = Governments.values()[new Random().nextInt(Governments.values().length)];
        tech = Tech.values()[new Random().nextInt(Tech.values().length)];
        resource = Resources.values()[new Random().nextInt(Resources.values().length)];
        systemSize = 1;
        systemName = name;
        planets = new ArrayList<Planet>();
    }



    /**
     * generates a random name for the system from a  predetermined list of names
     * @return returns a string representing the name for the system
     */
    private String generateRandomName(){
        String[] nameList = new String[]{
                "Acamar",
                "Adahn",		// The alternate personality for The Nameless One in "Planescape: Torment"
                "Aldea",
                "Andevian",
                "Antedi",
                "Balosnee",
                "Baratas",
                "Brax",			// One of the heroes in Master of Magic
                "Bretel",		// This is a Dutch device for keeping your pants up.
                "Calondia",
                "Campor",
                "Capelle",		// The city I lived in while programming this game
                "Carzon",
                "Castor",		// A Greek demi-god
                "Cestus",
                "Cheron",
                "Courteney",	// After Courteney Cox…
                "Daled",
                "Damast",
                "Davlos",
                "Deneb",
                "Deneva",
                "Devidia",
                "Draylon",
                "Drema",
                "Endor",
                "Esmee",		// One of the witches in Pratchett's Discworld
                "Exo",
                "Ferris",		// Iron
                "Festen",		// A great Scandinavian movie
                "Fourmi",		// An ant, in French
                "Frolix",		// A solar system in one of Philip K. Dick's novels
                "Gemulon",
                "Guinifer",		// One way of writing the name of king Arthur's wife
                "Hades",		// The underworld
                "Hamlet",		// From Shakespeare
                "Helena",		// Of Troy
                "Hulst",		// A Dutch plant
                "Iodine",		// An element
                "Iralius",
                "Janus",		// A seldom encountered Dutch boy's name
                "Japori",
                "Jarada",
                "Jason",		// A Greek hero
                "Kaylon",
                "Khefka",
                "Kira",			// My dog's name
                "Klaatu",		// From a classic SF movie
                "Klaestron",
                "Korma",		// An Indian sauce
                "Kravat",		// Interesting spelling of the French word for "tie"
                "Krios",
                "Laertes",		// A king in a Greek tragedy
                "Largo",
                "Lave",			// The starting system in Elite
                "Ligon",
                "Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
                "Magrat",		// The second of the witches in Pratchett's Discworld
                "Malcoria",
                "Melina",
                "Mentar",		// The Psilon home system in Master of Orion
                "Merik",
                "Mintaka",
                "Montor",		// A city in Ultima III and Ultima VII part 2
                "Mordan",
                "Myrthe",		// The name of my daughter
                "Nelvana",
                "Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
                "Nyle",			// An interesting spelling of the great river
                "Odet",
                "Og",			// The last of the witches in Pratchett's Discworld
                "Omega",		// The end of it all
                "Omphalos",		// Greek for navel
                "Orias",
                "Othello",		// From Shakespeare
                "Parade",		// This word means the same in Dutch and in English
                "Penthara",
                "Picard",		// The enigmatic captain from ST:TNG
                "Pollux",		// Brother of Castor
                "Quator",
                "Rakhar",
                "Ran",			// A film by Akira Kurosawa
                "Regulas",
                "Relva",
                "Rhymus",
                "Rochani",
                "Rubicum",		// The river Ceasar crossed to get into Rome
                "Rutia",
                "Sarpeidon",
                "Sefalla",
                "Seltrice",
                "Sigma",
                "Sol",			// That's our own solar system
                "Somari",
                "Stakoron",
                "Styris",
                "Talani",
                "Tamus",
                "Tantalos",		// A king from a Greek tragedy
                "Tanuga",
                "Tarchannen",
                "Terosa",
                "Thera",		// A seldom encountered Dutch girl's name
                "Titan",		// The largest moon of Jupiter
                "Torin",		// A hero from Master of Magic
                "Triacus",
                "Turkana",
                "Tyrus",
                "Umberlee",		// A god from AD&D, which has a prominent role in Baldur's Gate
                "Utopia",		// The ultimate goal
                "Vadera",
                "Vagra",
                "Vandor",
                "Ventax",
                "Xenon",
                "Xerxes",		// A Greek hero
                "Yew",			// A city which is in almost all of the Ultima games
                "Yojimbo",		// A film by Akira Kurosawa
                "Zalkon",
                "Zuul"			// From the first Ghostbusters movie
        };

        return nameList[(int) ((Math.random() * nameList.length) - 1)];
    }


    /**
     * getter for the planers variable
     * @return returns the ArrayList containing the planets in the System
     */
    public ArrayList<Planet> getPlanets() {
        return planets;
    }


    /**
     * getter for the systemName variable
     * @return returns the system name
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * toString method for the SolarSystem class which returns a string containing
     * information relevant to the
     * class
     * @return returns the string with information about the SolarSystem
     */
    @Override
    public String toString() {

        return " -SolarSystem{" +
                "planet_size = " + planets.size() +
                ", systemSize = " + systemSize +
                ", systemName = " + systemName + '\'' +
                ", coords = " + Arrays.toString(coords) +
                ", gov = " + gov +
                ", tech_lvl =  " + tech +
                ", resource = " + resource +
                '}';
    }
    /**
     * getter for the coords variable
     * @return returns array representing the coords of the system
     */
    public int[] getCoords() {
        return coords;
    }
}
