package gov.nasa.spaceapps.bloomerang.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;
import gov.nasa.spaceapps.bloomerang.utils.Constants;

public class Data implements BloomerangDataLoader{
	private Map<Coordinates, Map<Integer, Double>> temperatureMap;
	private Map<Coordinates, Map<Integer, Double>> salinityMap;
	private Map<Coordinates, Map<Integer, Double>> disolvedOxigenMap;
	private Map<Coordinates, Map<Integer, Double>> phosphateMap;
	private Map<Coordinates, Map<Integer, Double>> nitrateMap;
	
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public Data() {
		this.temperatureMap = new HashMap<>();
		this.salinityMap = new HashMap<>();
		this.disolvedOxigenMap = new HashMap<>();
		this.phosphateMap = new HashMap<>();
		this.nitrateMap = new HashMap<>();
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
	
	public void loadTemperatures(String[] values) {
		Coordinates coordinates;
		Double value = 0.0;
		Double item = 0.0;
		int count = 0;
		if(values.length < 2) {
			return;
		}
		Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
		Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		coordinates = new Coordinates(latitude, longitude);
		for(int i=2; i<8; i++) {
			try {
				Map<Integer, Double> deeps = temperatureMap.getOrDefault(coordinates, new HashMap<>()); 
				item = Double.valueOf(values[i].replace(".", ""))/1000;
				value += item;
				count++;
				deeps.put((i-1)*5, item);
				this.temperatureMap.put(coordinates, deeps);
			} catch(IndexOutOfBoundsException e) {
				break;
			}	
		}
		Map<Integer, Double> deeps = temperatureMap.getOrDefault(coordinates, new HashMap<>());
		deeps.put(0, value/count);
		this.temperatureMap.put(coordinates, deeps);
	}
	
	public void loadSalinity(String[] values) {
		Coordinates coordinates;
		Double value = 0.0;
		Double item = 0.0;
		int count = 0;
		if(values.length < 2) {
			return;
		}
		Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
		Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		coordinates = new Coordinates(latitude, longitude);
		for(int i=2; i<8; i++) {
			try {
				Map<Integer, Double> deeps = salinityMap.getOrDefault(coordinates, new HashMap<>()); 
				item = Double.valueOf(values[i].replace(".", ""))/1000;
				value += item;
				count++;
				deeps.put((i-1)*5, item);
				this.salinityMap.put(coordinates, deeps);
			} catch(IndexOutOfBoundsException e) {
				break;
			}	
		}
		Map<Integer, Double> deeps = salinityMap.getOrDefault(coordinates, new HashMap<>());
		deeps.put(0, item/count);
		this.salinityMap.put(coordinates, deeps);
	}
	
	public void loadDisolvedOxigen(String[] values) {
		Coordinates coordinates;
		Double value = 0.0;
		Double item = 0.0;
		int count = 0;
		if(values.length < 2) {
			return;
		}
		Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
		Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		coordinates = new Coordinates(latitude, longitude);
		for(int i=2; i<8; i++) {
			try {
				Map<Integer, Double> deeps = disolvedOxigenMap.getOrDefault(coordinates, new HashMap<>()); 
				item = Double.valueOf(values[i].replace(".", ""))/1000;
				value += item;
				count++;
				deeps.put((i-1)*5, item);
				this.disolvedOxigenMap.put(coordinates, deeps);
			} catch(IndexOutOfBoundsException e) {
				break;
			}	
		}
		Map<Integer, Double> deeps = disolvedOxigenMap.getOrDefault(coordinates, new HashMap<>());
		deeps.put(0, item/count);
		this.disolvedOxigenMap.put(coordinates, deeps);
	}
	
	public void loadPhosphate(String[] values) {
		Coordinates coordinates;
		Double value = 0.0;
		Double item = 0.0;
		int count = 0;
		if(values.length < 2) {
			return;
		}
		Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
		Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		coordinates = new Coordinates(latitude, longitude);
		for(int i=2; i<8; i++) {
			try {
				Map<Integer, Double> deeps = phosphateMap.getOrDefault(coordinates, new HashMap<>()); 
				item = Double.valueOf(values[i].replace(".", ""))/1000;
				value += item;
				count++;
				deeps.put((i-1)*5, item);
				this.phosphateMap.put(coordinates, deeps);
			} catch(IndexOutOfBoundsException e) {
				break;
			}	
		}
		Map<Integer, Double> deeps = phosphateMap.getOrDefault(coordinates, new HashMap<>());
		deeps.put(0, value/count);
		this.phosphateMap.put(coordinates, deeps);
	}
	
	public void loadNitrate(String[] values) {
		Coordinates coordinates;
		Double value = 0.0;
		Double item = 0.0;
		int count = 0;
		if(values.length < 2) {
			return;
		}
		Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
		Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		coordinates = new Coordinates(latitude, longitude);
		for(int i=2; i<8; i++) {
			try {
				Map<Integer, Double> deeps = nitrateMap.getOrDefault(coordinates, new HashMap<>()); 
				item = Double.valueOf(values[i].replace(".", ""))/1000;
				value += item;
				count++;
				deeps.put((i-1)*5, item);
				this.nitrateMap.put(coordinates, deeps);
			} catch(IndexOutOfBoundsException e) {
				break;
			}	
		}
		Map<Integer, Double> deeps = nitrateMap.getOrDefault(coordinates, new HashMap<>());
		deeps.put(0, value/count);
		this.nitrateMap.put(coordinates, deeps);
	}

	@Override
	public void load() {
		String temperatureLoc = "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_A5B7_t07gp01.csv";
		String salinityLoc = "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_A5B7_s07gp01.csv";
		String oxyLoc = "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_all_O07gp01.csv";
		String phosphateLoc = "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_all_p07gp01.csv";
		String nitrateLoc = "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_all_n07gp01.csv";
		
		readDataTemperatures(temperatureLoc);
		readDataSalinity(salinityLoc);
		readDataDisolvedOxigen(oxyLoc);
		readDataPhosphate(phosphateLoc);
		readDataNitrate(nitrateLoc);
	}
	
	public void readDataTemperatures(String file) {
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(Constants.COMMENT_SYMBOL)) {
    	    		String[] values = line.split(Constants.CSV_SYMBOL);
    	    		loadTemperatures(values);
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void readDataSalinity(String file) {
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(Constants.COMMENT_SYMBOL)) {
    	    		String[] values = line.split(Constants.CSV_SYMBOL);
    	    		loadSalinity(values);
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void readDataDisolvedOxigen(String file) {
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(Constants.COMMENT_SYMBOL)) {
    	    		String[] values = line.split(Constants.CSV_SYMBOL);
    	    		loadDisolvedOxigen(values);
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void readDataPhosphate(String file) {
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(Constants.COMMENT_SYMBOL)) {
    	    		String[] values = line.split(Constants.CSV_SYMBOL);
    	    		loadPhosphate(values);
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void readDataNitrate(String file) {
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(Constants.COMMENT_SYMBOL)) {
    	    		String[] values = line.split(Constants.CSV_SYMBOL);
    	    		loadNitrate(values);
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public Map<Coordinates, Map<Integer, Double>> getTemperatureMap() {
		return temperatureMap;
	}

	public void setTemperatureMap(Map<Coordinates, Map<Integer, Double>> temperatureMap) {
		this.temperatureMap = temperatureMap;
	}

	public Map<Coordinates, Map<Integer, Double>> getSalinityMap() {
		return salinityMap;
	}

	public void setSalinityMap(Map<Coordinates, Map<Integer, Double>> salinityMap) {
		this.salinityMap = salinityMap;
	}

	public Map<Coordinates, Map<Integer, Double>> getDisolvedOxigenMap() {
		return disolvedOxigenMap;
	}

	public void setDisolvedOxigenMap(Map<Coordinates, Map<Integer, Double>> disolvedOxigenMap) {
		this.disolvedOxigenMap = disolvedOxigenMap;
	}

	public Map<Coordinates, Map<Integer, Double>> getPhosphateMap() {
		return phosphateMap;
	}

	public void setPhosphateMap(Map<Coordinates, Map<Integer, Double>> phosphateMap) {
		this.phosphateMap = phosphateMap;
	}

	public Map<Coordinates, Map<Integer, Double>> getNitrateMap() {
		return nitrateMap;
	}

	public void setNitrateMap(Map<Coordinates, Map<Integer, Double>> nitrateMap) {
		this.nitrateMap = nitrateMap;
	}
	
}
