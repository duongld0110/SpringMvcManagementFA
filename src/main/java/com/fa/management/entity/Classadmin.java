package com.fa.management.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classadmin", catalog = "fa_g1")
public class Classadmin implements java.io.Serializable {
	private static final long serialVersionUID = -3200645528854185159L;
	private Integer classAdminId;
	private Integer classId;
	private Integer classAdminProfileId;
	private String remarks;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Classadmin() {
	}

	public Classadmin(Integer classId, Integer classAdminProfileId, String remarks, Set<Classbatch> classbatches) {
		this.classId = classId;
		this.classAdminProfileId = classAdminProfileId;
		this.remarks = remarks;
		this.classbatches = classbatches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ClassAdminID", unique = true, nullable = false)
	public Integer getClassAdminId() {
		return this.classAdminId;
	}

	public void setClassAdminId(Integer classAdminId) {
		this.classAdminId = classAdminId;
	}

	@Column(name = "ClassID")
	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name = "ClassAdminProfileID")
	public Integer getClassAdminProfileId() {
		return this.classAdminProfileId;
	}

	public void setClassAdminProfileId(Integer classAdminProfileId) {
		this.classAdminProfileId = classAdminProfileId;
	}

	@Column(name = "Remarks", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classadmin")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
