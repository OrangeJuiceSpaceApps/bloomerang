package gov.nasa.spaceapps.bloomerang.interfaces.impl;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;
import gov.nasa.spaceapps.bloomerang.interfaces.Bloomerang;
import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;
import gov.nasa.spaceapps.bloomerang.interfaces.Risk;

import java.util.Iterator;
import java.util.Map;

public class BloomerangImpl implements Bloomerang {

    private BloomerangDataLoader dataLoader;

    public BloomerangImpl(BloomerangDataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public Double getBloomRiskPercentage(Risk risk, Coordinates coordinates) {
    	try {
	    	this.dataLoader.load();
	
	        Double percentageRisk = null;
	
	        Map<Integer, Double> salinity = this.dataLoader.getSalinityMap().get(coordinates);
	        Map<Integer, Double> temperature = this.dataLoader.getTemperatureMap().get(coordinates);
	        Map<Integer, Double> nitrate = this.dataLoader.getNitrateMap().get(coordinates);
	        Map<Integer, Double> phosphate = this.dataLoader.getPhosphateMap().get(coordinates);
	        Map<Integer, Double> disolvedOxigen = this.dataLoader.getDisolvedOxigenMap().get(coordinates);
	       
	        if(risk.isRiskSalinity(salinity.get(0))) {
		        Iterator<Double> it = salinity.values().iterator();
		        Double preValue = null;
		        Double nexValue = null;
		        if (it.hasNext()) {
		            preValue = it.next();
		        }
		        while (it.hasNext()) {
		            nexValue = it.next();
		            if(Math.abs((preValue - nexValue)*0.15) > 1) {
		            	percentageRisk = 0.0;
		            	return percentageRisk;
		            }
		        }
		        percentageRisk = 0.1;
	        }
	        if(percentageRisk == null) {
	        	percentageRisk = risk.getRiskPercentageTemperature(temperature.get(0));
	        } else {
	        	percentageRisk += risk.getRiskPercentageTemperature(temperature.get(0));
	        }
	        
	        percentageRisk += risk.getRiskPercentageNitratePhosphate(nitrate.get(0), phosphate.get(0));
	        
	        if(risk.isRiskDisolvedOxigen(disolvedOxigen.get(0))) {
	        	percentageRisk += 0.1;
	        }
	        
	        if(percentageRisk != null) {
	        	percentageRisk = percentageRisk*100/320.0;
	        }
	        
	        return percentageRisk;
    	 } catch (Exception e){
        	return null;
        }
    }
}
