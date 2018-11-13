package com.spms20.datahub.repositories.verizon;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spms20.datahub.domain.VerizonLoginData;

@Repository
public interface VerizonLoginDataRepository extends CrudRepository<VerizonLoginData, Long> {
	
	@Query("select date_trunc('hour', tclo.loginTime) as loginTime, count(*) from VerizonLoginData tclo where tclo.userId = (select tcu.userId from VerizonUser tcu where tcu.userId = tclo.userId and tcu.compName not in ('삼성SDS','SDSA')) group by date_trunc('hour', tclo.loginTime)")
	List<Object[]> queryLoginDataOutput();
}
