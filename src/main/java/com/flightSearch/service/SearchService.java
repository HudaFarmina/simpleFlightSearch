package com.flightSearch.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.flightSearch.dto.Flight;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchService {

	public List<Flight> searchFlightByUserInput(String flightnumber,String destination, String  origin, String date)
			throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {

		List<Flight> flightList = new ArrayList<Flight>();
		
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("flight-docs/flight-sample.json"));

		Flight myFlightInfo = new Flight();

		for (Object o : jsonArray) {
			JSONObject flightData = (JSONObject) o;

			String strName = (String) flightData.get("flightNumber");
			String arrivatedate = (String) flightData.get("arrival");
			
			 String originStr = (String) flightData.get("origin"); 
			 String destinationStr =(String) flightData.get("destination");

			// System.out.println(" Flight Number ::: " +strName);
			// System.out.println("Arrival date ::: " +arrivatedate);

			if ((flightnumber.matches(strName) && date.matches(arrivatedate)) || 
			(destination.matches(destinationStr) && (origin.matches(originStr) && (date.matches(arrivatedate)))))
			{
				System.out.println("Flight Number ::: " + strName);
				System.out.println("Arrival date ::: " + arrivatedate);

				System.out.println("Destination  ::: " + destination);
				System.out.println("Origin ::: " + originStr);
				
				myFlightInfo.setFlightNumber(flightData.get("flightNumber").toString());
				myFlightInfo.setAircraft(flightData.get("aircraft").toString());
				myFlightInfo.setOrigin(flightData.get("origin").toString());
				myFlightInfo.setDeparture(flightData.get("departure").toString());
				myFlightInfo.setDestination(flightData.get("destination").toString());
				myFlightInfo.setArrival(flightData.get("arrival").toString());
				myFlightInfo.setCarrier(flightData.get("carrier").toString());
				myFlightInfo.setDistance((Long) flightData.get("distance"));
				myFlightInfo.setTravelTime(flightData.get("travelTime").toString());
				myFlightInfo.setStatus(flightData.get("status").toString());

				flightList.add(myFlightInfo);

				System.out.println("Added to  the list ::");

				System.out.println(flightList);

			} else {
				log.debug("No record Found");
			}
		}
		return flightList;
	}
}
