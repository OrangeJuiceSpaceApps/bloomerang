package gov.nasa.spaceapps.bloomerang.entities;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;

public class Data implements BloomerangDataLoader{
	private Double latitude;
	private Double longitude;
	private Double temperature;
	private Double salinity;
	private Double oxy;
	private Double phosphate;
	private Double nitrate;
	
	/**
	 * @param String.valueOf(d)latitude2
	 * @param Doubleitude
	 */
	public Data(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Data(Double latitude, Double longitude, Double temperature, Double salinity, Double oxy, Double phosphate,
			Double nitrate) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperature = temperature;
		this.salinity = salinity;
		this.oxy = oxy;
		this.phosphate = phosphate;
		this.nitrate = nitrate;
	}
	
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getSalinity() {
		return salinity;
	}
	public void setSalinity(Double salinity) {
		this.salinity = salinity;
	}
	public Double getOxy() {
		return oxy;
	}
	public void setOxy(Double oxy) {
		this.oxy = oxy;
	}
	public Double getPhosphate() {
		return phosphate;
	}
	public void setPhosphate(Double phosphate) {
		this.phosphate = phosphate;
	}
	public Double getNitrate() {
		return nitrate;
	}
	public void setNitrate(Double nitrate) {
		this.nitrate = nitrate;
	}
	
	@Override
	public String toString() {
		try {
			return (new ObjectMapper()).writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Coordinates, Map<Integer, Integer>> getSalinityMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Coordinates, Map<Integer, Integer>> getTemperatureMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Coordinates, Map<Integer, Integer>> getDisolvedOxigenMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Coordinates, Map<Integer, Integer>> getPhosphateMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Coordinates, Map<Integer, Integer>> getNitrateMap() {
		// TODO Auto-generated method stub
		return null;
	}
}