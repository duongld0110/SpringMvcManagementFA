package com.fa.management.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location", catalog = "fa_g1")
public class Location implements java.io.Serializable {
	private static final long serialVersionUID = 8846749444692871734L;
	private int locationId;
	private String remarks;
	private String locationName;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Location() {
	}

	public Location(int locationId) {
		this.locationId = locationId;
	}

	public Location(int locationId, String remarks, String locationName, Set<Classbatch> classbatches) {
		this.locationId = locationId;
		this.remarks = remarks;
		this.locationName = locationName;
		this.classbatches = classbatches;
	}

	@Id

	@Column(name = "LocationID", unique = true, nullable = false)
	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Column(name = "Remarks", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "LocationName", length = 50)
	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
