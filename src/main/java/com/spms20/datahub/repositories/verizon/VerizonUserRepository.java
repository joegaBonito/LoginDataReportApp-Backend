package com.spms20.datahub.repositories.verizon;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spms20.datahub.domain.VerizonUser;

@Repository
public interface VerizonUserRepository extends CrudRepository<VerizonUser, Long> {
	@Query("SELECT u.userId, u.compName FROM VerizonUser u")
	List<VerizonUser> getUsersByIdAndCompCode();
	
}
