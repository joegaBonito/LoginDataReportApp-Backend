package com.spms20.datahub.controllers;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spms20.datahub.domain.SprintLoginData;
import com.spms20.datahub.domain.VerizonLoginData;
import com.spms20.datahub.domain.LoginDataOutput;
import com.spms20.datahub.services.SprintLoginDataService;
import com.spms20.datahub.services.VerizonLoginDataService;

@RestController
public class LoginDataController {
	
	@Autowired
	private SprintLoginDataService sprintLoginDataService;
	
	@Autowired
	private VerizonLoginDataService verizonLoginDataService;
	
	public LoginDataController(){};
	
	public LoginDataController(SprintLoginDataService sprintLoginDataService,
			VerizonLoginDataService verizonLoginDataService) {
		this.sprintLoginDataService =sprintLoginDataService;
		this.verizonLoginDataService = verizonLoginDataService;
	}
	
	@RequestMapping(value = "/api/sprint/getLoginDataList", method = RequestMethod.GET)
	public ResponseEntity<?> getSprintLoginDataList() {
		return new ResponseEntity<List<SprintLoginData>>(this.sprintLoginDataService.getLoginDataList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/verizon/getLoginDataList", method = RequestMethod.GET)
	public ResponseEntity<?> getVerizonLoginDataList() {
		return new ResponseEntity<List<VerizonLoginData>>(this.verizonLoginDataService.getLoginDataList(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:8000")
	@RequestMapping(value = "/api/sprint/getLoginDataOutputList", method = RequestMethod.GET)
	public ResponseEntity<?> getSprintLoginDataOutpuList() {
		List<LoginDataOutput> ldos = new LinkedList<LoginDataOutput>();
		List<Object[]> objs = this.sprintLoginDataService.getLoginDataOutpuList();
		for (int i = 0; i < objs.size();i++)
		{
			LoginDataOutput ldo = new LoginDataOutput();
			ldo.setLoginTime((Timestamp) objs.get(i)[0]);
			ldo.setCount((long) objs.get(i)[1]);
			ldos.add(ldo);
		}
		return new ResponseEntity<List<LoginDataOutput>>(ldos,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:8000")
	@RequestMapping(value = "/api/verizon/getLoginDataOutputList", method = RequestMethod.GET)
	public ResponseEntity<?> getVerizonLoginDataOutpuList() {
		List<LoginDataOutput> ldos = new LinkedList<LoginDataOutput>();
		List<Object[]> objs = this.verizonLoginDataService.getLoginDataOutpuList();
		for (int i = 0; i < objs.size();i++)
		{
			LoginDataOutput ldo = new LoginDataOutput();
			ldo.setLoginTime((Timestamp) objs.get(i)[0]);
			ldo.setCount((long) objs.get(i)[1]);
			ldos.add(ldo);
		}
		return new ResponseEntity<List<LoginDataOutput>>(ldos,HttpStatus.OK);
	}
}
