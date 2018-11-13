package com.spms20.datahub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tn_cf_login_out", schema="netbiz_astm")
public class VerizonLoginData {
	@Id
	@Column(name = "session_id")
	String sessionId;
	@Column(name = "user_id")
	String userId;
	@Column(name = "login_time")
	String loginTime;
	@Column(name = "logout_time")
	String logoutTime;
	@Column(name = "use_ip")
	String useIp;
	@Column(name = "req_type")
	String reqType;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getUseIp() {
		return useIp;
	}
	public void setUseIp(String useIp) {
		this.useIp = useIp;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	
}
