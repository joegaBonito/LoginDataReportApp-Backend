package com.spms20.datahub.repositories.sprint;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spms20.datahub.domain.SprintSitesCoordinate;

@Repository
public interface SprintSitesCoordinateRepository extends CrudRepository<SprintSitesCoordinate, Long> {
	
	@Query("select ssc.latitude, ssc.longitude from SprintSitesCoordinate ssc")
	List<Object[]> querySitesCoordinate();
}
