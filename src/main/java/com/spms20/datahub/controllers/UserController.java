package com.spms20.datahub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spms20.datahub.domain.SprintUser;
import com.spms20.datahub.domain.VerizonUser;
import com.spms20.datahub.services.SprintUserService;
import com.spms20.datahub.services.VerizonUserService;

@RestController
public class UserController {
	@Autowired
	private SprintUserService sprintUserService;
	
	@Autowired
	private VerizonUserService verizonUserService;
	
	public UserController(SprintUserService sprintUserService,
			VerizonUserService verizonUserService) {
		this.sprintUserService = sprintUserService;
		this.verizonUserService = verizonUserService;
	}
	
	@RequestMapping(value="/api/sprint/getUserList",method=RequestMethod.GET) 
	public ResponseEntity<?> getSprintUserList() {
		return new ResponseEntity<List<SprintUser>>(this.sprintUserService.getUserList(),HttpStatus.OK);
	}
	@RequestMapping(value="/api/verizon/getUserList",method=RequestMethod.GET) 
	public ResponseEntity<?> getVerizonUserList() {
		return new ResponseEntity<List<VerizonUser>>(this.verizonUserService.getUserList(),HttpStatus.OK);
	}
}
