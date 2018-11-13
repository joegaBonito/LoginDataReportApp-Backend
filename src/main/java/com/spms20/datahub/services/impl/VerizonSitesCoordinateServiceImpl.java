package com.spms20.datahub.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spms20.datahub.domain.VerizonSitesCoordinate;
import com.spms20.datahub.repositories.verizon.VerizonSitesCoordinateRepository;
import com.spms20.datahub.services.VerizonSitesCoordinateService;

@Service
public class VerizonSitesCoordinateServiceImpl implements VerizonSitesCoordinateService {
	@Autowired
	private VerizonSitesCoordinateRepository verizonSitesCoordinateRepository;

	public VerizonSitesCoordinateServiceImpl(VerizonSitesCoordinateRepository verizonSitesCoordinateRepository) {
		this.verizonSitesCoordinateRepository = verizonSitesCoordinateRepository;
	}

	@Override
	public List<VerizonSitesCoordinate> getVerizonSitesCoordinates() {
		List<VerizonSitesCoordinate> vscs = new LinkedList<VerizonSitesCoordinate>();
		List<Object[]> objs = this.verizonSitesCoordinateRepository.querySitesCoordinate();
		for (int i = 0; i < objs.size(); i++) {
			if (!objs.get(i)[0].equals("") || !objs.get(i)[1].equals("")) {
				VerizonSitesCoordinate vsc = new VerizonSitesCoordinate();
				vsc.setLatitude((String) objs.get(i)[0]);
				vsc.setLongitude((String) objs.get(i)[1]);
				vscs.add(vsc);
			}
		}
		return vscs;
	}

}
