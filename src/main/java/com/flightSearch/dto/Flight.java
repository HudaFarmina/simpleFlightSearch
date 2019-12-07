package com.flightSearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight{
		
	private  String flightNumber;
    private String carrier;
    private String origin;
    private String departure;
    private String destination;
    private String arrival;
    private String aircraft;
    private Long distance;
    private String travelTime;
    private String status;

}
