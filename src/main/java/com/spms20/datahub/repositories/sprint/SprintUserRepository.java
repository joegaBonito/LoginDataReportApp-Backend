package com.spms20.datahub.repositories.sprint;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spms20.datahub.domain.SprintUser;

@Repository
public interface SprintUserRepository extends CrudRepository<SprintUser, Long> {
	@Query("SELECT u.userId, u.compName FROM SprintUser u")
	List<SprintUser> getUsersByIdAndCompCode();
	
}
