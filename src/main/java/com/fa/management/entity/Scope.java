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
@Table(name = "scope", catalog = "fa_g1")
public class Scope implements java.io.Serializable {

	private static final long serialVersionUID = -6953918865051051874L;
	private Integer scopeId;
	private int classId;
	private String remarks;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Scope() {
	}

	public Scope(int classId, String remarks) {
		this.classId = classId;
		this.remarks = remarks;
	}

	public Scope(int classId, String remarks, Set<Classbatch> classbatches) {
		this.classId = classId;
		this.remarks = remarks;
		this.classbatches = classbatches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ScopeID", unique = true, nullable = false)
	public Integer getScopeId() {
		return this.scopeId;
	}

	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

	@Column(name = "ClassID", nullable = false)
	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Column(name = "Remarks", nullable = false, length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "scope")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
