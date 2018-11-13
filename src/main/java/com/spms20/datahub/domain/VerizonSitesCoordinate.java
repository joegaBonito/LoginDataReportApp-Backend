package com.spms20.datahub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tn_dply_site_info",schema = "netbiz_spms")
public class VerizonSitesCoordinate {
    @Id
    @Column(name="site_uid")
    String siteUid;
    
    @Column(name="latitude")
    String latitude;
    
    @Column(name="longitude")
    String longitude;

	public String getSiteUid() {
		return siteUid;
	}

	public void setSiteUid(String siteUid) {
		this.siteUid = siteUid;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
    
}
