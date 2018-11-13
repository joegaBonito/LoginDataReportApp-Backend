package com.spms20.datahub.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spms20.datahub.domain.SprintUser;
import com.spms20.datahub.domain.VerizonUser;
import com.spms20.datahub.repositories.sprint.SprintUserRepository;
import com.spms20.datahub.services.SprintUserService;

@Service
public class SprintUserServiceImpl implements SprintUserService {
	
	@Autowired
	public SprintUserRepository userRepository;
	
	public SprintUserServiceImpl(SprintUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<SprintUser> getUserList() {
		return this.userRepository.getUsersByIdAndCompCode();
	}
}
