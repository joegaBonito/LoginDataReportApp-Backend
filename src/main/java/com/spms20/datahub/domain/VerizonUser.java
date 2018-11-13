package com.spms20.datahub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tn_cf_user",schema = "netbiz_astm")
public class VerizonUser {
	@Id
	@Column(name="user_id") 
	String userId;
	
	@Column(name="comp_name")
	String compName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
	
	
}
