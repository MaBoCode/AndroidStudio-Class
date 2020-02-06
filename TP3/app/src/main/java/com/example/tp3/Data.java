package com.example.tp3;

import java.util.ArrayList;

public class Data {
    private ArrayList<String> planets;
    private final String[] planetSizes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

    public Data() {
        installPlanets();
    }

    private void installPlanets() {
        planets = new ArrayList<>();
        planets.add("Mercure");
        planets.add("Venus");
        planets.add("Terre");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturne");
        planets.add("Uranus");
        planets.add("Neptune");
        planets.add("Pluton");
    }

    public String[] getPlanetSizes() {
        return planetSizes;
    }

    public ArrayList<String> getPlanets() {
        return planets;
    }
}
