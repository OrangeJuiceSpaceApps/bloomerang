package gov.nasa.spaceapps.bloomerang.interfaces.impl;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;
import gov.nasa.spaceapps.bloomerang.interfaces.Bloomerang;
import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;
import gov.nasa.spaceapps.bloomerang.interfaces.Risk;

import java.util.Map;

public class BloomerangImpl implements Bloomerang {

    private BloomerangDataLoader dataLoader;

    public BloomerangImpl(BloomerangDataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public Double getBloomRiskPercentage(Risk risk, Coordinates coordinates) {
        this.dataLoader.load();

        Double percentageRisk = null;

        Map<Integer, Double> salinity = this.dataLoader.getSalinityMap().get(coordinates);
        Map<Integer, Double> temperature = this.dataLoader.getTemperatureMap().get(coordinates);
        Map<Integer, Double> nitrate = this.dataLoader.getNitrateMap().get(coordinates);
        Map<Integer, Double> phosphate = this.dataLoader.getPhosphateMap().get(coordinates);
        Map<Integer, Double> disolvedOxigen = this.dataLoader.getDisolvedOxigenMap().get(coordinates);

        

        return percentageRisk;
    }
}
