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
@Table(name = "subsubjecttype", catalog = "fa_g1")
public class Subsubjecttype implements java.io.Serializable {

	private static final long serialVersionUID = 1107200073752154813L;
	private Integer subSubjectTypeId;
	private int classId;
	private String remarks;
	private String subSubjectTypeName;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Subsubjecttype() {
	}

	public Subsubjecttype(int classId) {
		this.classId = classId;
	}

	public Subsubjecttype(int classId, String remarks, String subSubjectTypeName, Set<Classbatch> classbatches) {
		this.classId = classId;
		this.remarks = remarks;
		this.subSubjectTypeName = subSubjectTypeName;
		this.classbatches = classbatches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "SubSubjectTypeID", unique = true, nullable = false)
	public Integer getSubSubjectTypeId() {
		return this.subSubjectTypeId;
	}

	public void setSubSubjectTypeId(Integer subSubjectTypeId) {
		this.subSubjectTypeId = subSubjectTypeId;
	}

	@Column(name = "ClassID", nullable = false)
	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Column(name = "Remarks", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "SubSubjectTypeName", length = 50)
	public String getSubSubjectTypeName() {
		return this.subSubjectTypeName;
	}

	public void setSubSubjectTypeName(String subSubjectTypeName) {
		this.subSubjectTypeName = subSubjectTypeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subsubjecttype")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
