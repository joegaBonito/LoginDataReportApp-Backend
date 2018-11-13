package com.spms20.datahub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spms20.datahub.domain.SprintSitesCoordinate;
import com.spms20.datahub.domain.VerizonSitesCoordinate;
import com.spms20.datahub.services.SprintSitesCoordinateService;
import com.spms20.datahub.services.VerizonSitesCoordinateService;

@RestController
public class SitesCoordinateController {
	
	@Autowired
	private SprintSitesCoordinateService sprintSitesCoordinateService;
	
	@Autowired
	private VerizonSitesCoordinateService verizonSitesCoordinateService;
	
	public SitesCoordinateController(SprintSitesCoordinateService sprintSitesCoordinateService,
			VerizonSitesCoordinateService verizonSitesCoordinateService) {
		this.sprintSitesCoordinateService = sprintSitesCoordinateService;
		this.verizonSitesCoordinateService = verizonSitesCoordinateService;
	}
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping(value="/api/sprint/sites_coordinate_info", method=RequestMethod.GET)
	public ResponseEntity<?> getSprintSitesCoordinate() {
		return new ResponseEntity<List<SprintSitesCoordinate>>(this.sprintSitesCoordinateService.getSprintSitesCoordinate(),HttpStatus.OK);
	}
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping(value="/api/verizon/sites_coordinate_info", method=RequestMethod.GET)
	public ResponseEntity<?> getVerizonSitesCoordinate() {
		
		return new ResponseEntity<List<VerizonSitesCoordinate>>(this.verizonSitesCoordinateService.getVerizonSitesCoordinates(),HttpStatus.OK);
	}
}
