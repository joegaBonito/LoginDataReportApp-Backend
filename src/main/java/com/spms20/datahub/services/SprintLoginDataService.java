package com.spms20.datahub.services;

import java.util.List;

import com.spms20.datahub.domain.SprintLoginData;

public interface SprintLoginDataService {
	public List<SprintLoginData> getLoginDataList();
	public List<Object[]> getLoginDataOutpuList();
}
