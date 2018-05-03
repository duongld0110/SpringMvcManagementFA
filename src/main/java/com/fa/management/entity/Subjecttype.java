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
@Table(name = "subjecttype", catalog = "fa_g1")
public class Subjecttype implements java.io.Serializable {
	private static final long serialVersionUID = 6613655502573812619L;
	private Integer subjectTypeId;
	private int classId;
	private String subjectTypeName;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Subjecttype() {
	}

	public Subjecttype(int classId) {
		this.classId = classId;
	}

	public Subjecttype(int classId, String subjectTypeName, Set<Classbatch> classbatches) {
		this.classId = classId;
		this.subjectTypeName = subjectTypeName;
		this.classbatches = classbatches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "SubjectTypeID", unique = true, nullable = false)
	public Integer getSubjectTypeId() {
		return this.subjectTypeId;
	}

	public void setSubjectTypeId(Integer subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	@Column(name = "ClassID", nullable = false)
	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Column(name = "SubjectTypeName", length = 50)
	public String getSubjectTypeName() {
		return this.subjectTypeName;
	}

	public void setSubjectTypeName(String subjectTypeName) {
		this.subjectTypeName = subjectTypeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subjecttype")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
