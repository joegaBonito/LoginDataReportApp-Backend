package com.spms20.datahub.services.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spms20.datahub.domain.SprintLoginData;
import com.spms20.datahub.domain.LoginDataOutput;
import com.spms20.datahub.domain.SprintUser;
import com.spms20.datahub.domain.VerizonLoginData;
import com.spms20.datahub.repositories.sprint.SprintLoginDataRepository;
import com.spms20.datahub.repositories.verizon.VerizonLoginDataRepository;
import com.spms20.datahub.services.VerizonLoginDataService;
import com.spms20.datahub.services.VerizonUserService;

@Service
public class VerizonLoginDataServiceImpl implements VerizonLoginDataService {

	@Autowired
	private VerizonLoginDataRepository loginDataRepository;

	@Autowired
	private VerizonUserService userService;

	public VerizonLoginDataServiceImpl(VerizonLoginDataRepository loginDataRepository, VerizonUserService userService) {
		this.loginDataRepository = loginDataRepository;
		this.userService = userService;
	}

	@Override
	public List<VerizonLoginData> getLoginDataList() {
		List<VerizonLoginData> lds = (List<VerizonLoginData>) this.loginDataRepository.findAll();	
		return lds;
	}
	
	public List<Object[]> getLoginDataOutpuList() {
		return this.loginDataRepository.queryLoginDataOutput();
	}

}
