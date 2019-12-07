package com.flightSearch.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightSearch.service.SearchService;

@RestController
@RequestMapping("/v1.0")
public class FlightSearchController {
	
	@Autowired
	SearchService search;
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = {"/search/{flightNumber}/{destination}/{origin}/{arrivalDate}"}, method = RequestMethod.GET)
	public ResponseEntity<?> getDetailFlightInfo(@RequestParam(required = false, defaultValue = "") String flightNumber,
			@RequestParam(required = false, defaultValue = "") String destination,
			@RequestParam(required = false, defaultValue = "") String origin,
			@RequestParam(required = false , defaultValue = "") String arrivalDate) 
		    throws FileNotFoundException, IOException, ParseException, java.text.ParseException
	{
	
		return new ResponseEntity<>(search.searchFlightByUserInput(flightNumber,destination,origin,arrivalDate), HttpStatus.OK);
	}
	

}
