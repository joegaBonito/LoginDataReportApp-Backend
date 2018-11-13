package com.spms20.datahub.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spms20.datahub.domain.VerizonUser;
import com.spms20.datahub.repositories.verizon.VerizonUserRepository;
import com.spms20.datahub.services.VerizonUserService;

@Service
public class VerizonUserServiceImpl implements VerizonUserService {
	
	@Autowired
	public VerizonUserRepository userRepository;
	
	public VerizonUserServiceImpl(VerizonUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<VerizonUser> getUserList() {
		return this.userRepository.getUsersByIdAndCompCode();
	}
}
