package gov.nasa.spaceapps.bloomerang.interfaces;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;

import java.util.Map;

public interface BloomerangDataLoader {

    void load();

    Map<Coordinates, Map<Integer, Integer>> getSalinityMap();

    Map<Coordinates, Map<Integer, Integer>> getTemperatureMap();

    Map<Coordinates, Map<Integer, Integer>> getDisolvedOxigenMap();

    Map<Coordinates, Map<Integer, Integer>> getPhosphateMap();

    Map<Coordinates, Map<Integer, Integer>> getNitrateMap();

}
