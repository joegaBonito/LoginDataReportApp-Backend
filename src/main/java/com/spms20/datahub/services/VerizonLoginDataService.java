package com.spms20.datahub.services;

import java.util.List;

import com.spms20.datahub.domain.SprintLoginData;
import com.spms20.datahub.domain.VerizonLoginData;

public interface VerizonLoginDataService {
	public List<VerizonLoginData> getLoginDataList();
	public List<Object[]> getLoginDataOutpuList();
}
