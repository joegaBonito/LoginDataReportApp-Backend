package com.spms20.datahub.services.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spms20.datahub.domain.SprintLoginData;
import com.spms20.datahub.repositories.sprint.SprintLoginDataRepository;
import com.spms20.datahub.services.SprintLoginDataService;
import com.spms20.datahub.services.SprintUserService;

@Service
public class SprintLoginDataServiceImpl implements SprintLoginDataService {

	@Autowired
	private SprintLoginDataRepository loginDataRepository;

	@Autowired
	private SprintUserService userService;

	public SprintLoginDataServiceImpl(SprintLoginDataRepository loginDataRepository, SprintUserService userService) {
		this.loginDataRepository = loginDataRepository;
		this.userService = userService;
	}

	@Override
	public List<SprintLoginData> getLoginDataList() {
		List<SprintLoginData> lds = (List<SprintLoginData>) this.loginDataRepository.findAll();	
		return lds;
	}
	
	public List<Object[]> getLoginDataOutpuList() {
		return this.loginDataRepository.queryLoginDataOutput();
	}

}
