package gov.nasa.spaceapps.bloomerang.interfaces;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;

import java.util.Map;

public interface BloomerangDataLoader {

    void load();

    Map<Coordinates, Map<Integer, Double>> getSalinityMap();

    Map<Coordinates, Map<Integer, Double>> getTemperatureMap();

    Map<Coordinates, Map<Integer, Double>> getDisolvedOxigenMap();

    Map<Coordinates, Map<Integer, Double>> getPhosphateMap();

    Map<Coordinates, Map<Integer, Double>> getNitrateMap();

}
