package org.spaceappschallenge.BloomAPI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String CSV_SYMBOL = ",";
	public static final String COMMENT_SYMBOL = "#";

	public static void main( String[] args )
    {
    	Map<String, Data> records =  new TreeMap<>();
    	readDataTemperature(records, "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_A5B7_t07gp01.csv");
    	readDataSalinity(records, "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_A5B7_s07gp01.csv");
    	readDataOxy(records, "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_all_O07gp01.csv");
    	readDataPhosphate(records, "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_all_p07gp01.csv");
    	readDataNitrate(records, "C:\\Users\\Javier\\Desktop\\NASAAAA\\woa18_all_n07gp01.csv");
        System.out.println(records.get("-0.5|0.5"));
    }
    
    public static Map<String, Data> readDataTemperature(Map<String, Data> records, String file) {
//    	Map<String, Data> records =  new TreeMap<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(COMMENT_SYMBOL)) {
    	    		String[] values = line.split(CSV_SYMBOL);
    	    		if(values.length >= 2) {
    	    			Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
    	    			Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		    	        String key = latitude + "|" + longitude;
		    	        Data record = records.getOrDefault(key, new Data(latitude, longitude));
	    	    		mapTemperature(record, values);
//	    	    		mapSalinity(record, values);
//	    	    		mapOxy(record, values);
//	    	    		mapPhosphate(record, values);
						records.put(key, record);
    	    		}
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return records;
    }

	private static void mapTemperature(Data record, String[] values) {
		Double value = Double.valueOf(0);
		int count = 0;
		for(int i=2; i<8; i++) {
			try {
				value += Double.valueOf(values[i].replace(".", ""))/1000;
				count++;
			} catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		if(count > 0) {
			record.setTemperature(value/count);
		}
	}
	
	public static Map<String, Data> readDataSalinity(Map<String, Data> records, String file) {
//    	Map<String, Data> records =  new TreeMap<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(COMMENT_SYMBOL)) {
    	    		String[] values = line.split(CSV_SYMBOL);
    	    		if(values.length >= 2) {
    	    			Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
    	    			Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		    	        String key = latitude + "|" + longitude;
		    	        Data record = records.getOrDefault(key, new Data(latitude, longitude));
	    	    		mapSalinity(record, values);
//	    	    		mapSalinity(record, values);
//	    	    		mapOxy(record, values);
//	    	    		mapPhosphate(record, values);
						records.put(key, record);
    	    		}
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return records;
    }

	private static void mapSalinity(Data record, String[] values) {
		Double value = Double.valueOf(0);
		int count = 0;
		for(int i=2; i<8; i++) {
			try {
				value += Double.valueOf(values[i].replace(".", ""))/1000;
				count++;
			} catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		if(count > 0) {
			record.setSalinity(value/count);
		}
	}
	
	public static Map<String, Data> readDataOxy(Map<String, Data> records, String file) {
//    	Map<String, Data> records =  new TreeMap<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(COMMENT_SYMBOL)) {
    	    		String[] values = line.split(CSV_SYMBOL);
    	    		if(values.length >= 2) {
    	    			Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
    	    			Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		    	        String key = latitude + "|" + longitude;
		    	        Data record = records.getOrDefault(key, new Data(latitude, longitude));
	    	    		mapOxy(record, values);
//	    	    		mapSalinity(record, values);
//	    	    		mapOxy(record, values);
//	    	    		mapPhosphate(record, values);
						records.put(key, record);
    	    		}
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return records;
    }

	private static void mapOxy(Data record, String[] values) {
		Double value = Double.valueOf(0);
		int count = 0;
		for(int i=2; i<8; i++) {
			try {
				value += Double.valueOf(values[i].replace(".", ""))/1000;
				count++;
			} catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		if(count > 0) {
			record.setOxy(value/count);
		}
	}
	
	public static Map<String, Data> readDataPhosphate(Map<String, Data> records, String file) {
//    	Map<String, Data> records =  new TreeMap<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(COMMENT_SYMBOL)) {
    	    		String[] values = line.split(CSV_SYMBOL);
    	    		if(values.length >= 2) {
    	    			Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
    	    			Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		    	        String key = latitude + "|" + longitude;
		    	        Data record = records.getOrDefault(key, new Data(latitude, longitude));
	    	    		mapPhosphate(record, values);
//	    	    		mapSalinity(record, values);
//	    	    		mapOxy(record, values);
//	    	    		mapPhosphate(record, values);
						records.put(key, record);
    	    		}
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return records;
    }

	private static void mapPhosphate(Data record, String[] values) {
		Double value = Double.valueOf(0);
		int count = 0;
		for(int i=2; i<8; i++) {
			try {
				value += Double.valueOf(values[i].replace(".", ""))/1000;
				count++;
			} catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		if(count > 0) {
			record.setPhosphate(value/count);
		}
	}
	
	public static Map<String, Data> readDataNitrate(Map<String, Data> records, String file) {
//    	Map<String, Data> records =  new TreeMap<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	    	if(!line.substring(0, 1).equals(COMMENT_SYMBOL)) {
    	    		String[] values = line.split(CSV_SYMBOL);
    	    		if(values.length >= 2) {
    	    			Double latitude = Double.valueOf(values[0].replace(".", ""))/1000;
    	    			Double longitude = Double.valueOf(values[1].replace(".", ""))/1000;
		    	        String key = latitude + "|" + longitude;
		    	        Data record = records.getOrDefault(key, new Data(latitude, longitude));
	    	    		mapNitrate(record, values);
//	    	    		mapSalinity(record, values);
//	    	    		mapOxy(record, values);
//	    	    		mapPhosphate(record, values);
						records.put(key, record);
    	    		}
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return records;
    }

	private static void mapNitrate(Data record, String[] values) {
		Double value = Double.valueOf(0);
		int count = 0;
		for(int i=2; i<8; i++) {
			try {
				value += Double.valueOf(values[i].replace(".", ""))/1000;
				count++;
			} catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		if(count > 0) {
			record.setNitrate(value/count);
		}
	}
}
