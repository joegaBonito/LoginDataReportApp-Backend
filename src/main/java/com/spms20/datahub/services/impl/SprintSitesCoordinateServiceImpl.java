package com.spms20.datahub.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spms20.datahub.domain.SprintSitesCoordinate;
import com.spms20.datahub.repositories.sprint.SprintSitesCoordinateRepository;
import com.spms20.datahub.services.SprintSitesCoordinateService;

@Service
public class SprintSitesCoordinateServiceImpl implements SprintSitesCoordinateService{

	@Autowired
	private SprintSitesCoordinateRepository sprintSitesCoordinateRepository;
	
	public SprintSitesCoordinateServiceImpl(SprintSitesCoordinateRepository sprintSitesCoordinateRepository) {
		this.sprintSitesCoordinateRepository =sprintSitesCoordinateRepository;
	}
	
	@Override
	public List<SprintSitesCoordinate> getSprintSitesCoordinate() {
		List<SprintSitesCoordinate> sscs = new LinkedList<SprintSitesCoordinate>();
		List<Object[]> objs = this.sprintSitesCoordinateRepository.querySitesCoordinate();
		 for (int i = 0; i < objs.size();i++)
			{
			 if(!objs.get(i)[0].equals("") || !objs.get(i)[1].equals("")) {
			 SprintSitesCoordinate ssc = new SprintSitesCoordinate();
			 ssc.setLatitude((String) objs.get(i)[0]);
			 ssc.setLongitude((String) objs.get(i)[1]);
			 sscs.add(ssc);
			 }
			}
		 return sscs;
	}

}
