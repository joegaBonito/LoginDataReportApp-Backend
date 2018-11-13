package com.spms20.datahub.repositories.verizon;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spms20.datahub.domain.SprintSitesCoordinate;
import com.spms20.datahub.domain.VerizonSitesCoordinate;

@Repository
public interface VerizonSitesCoordinateRepository extends CrudRepository<VerizonSitesCoordinate, Long> {
	
	@Query("select vsc.latitude, vsc.longitude from VerizonSitesCoordinate vsc")
	List<Object[]> querySitesCoordinate();
}
