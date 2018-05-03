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
@Table(name = "deliverytype", catalog = "fa_g1")
public class Deliverytype implements java.io.Serializable {
	private static final long serialVersionUID = -6615029893675480636L;
	private Integer deliveryTypeId;
	private int classId;
	private String remarks;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Deliverytype() {
	}

	public Deliverytype(int classId, String remarks) {
		this.classId = classId;
		this.remarks = remarks;
	}

	public Deliverytype(int classId, String remarks, Set<Classbatch> classbatches) {
		this.classId = classId;
		this.remarks = remarks;
		this.classbatches = classbatches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "DeliveryTypeID", unique = true, nullable = false)
	public Integer getDeliveryTypeId() {
		return this.deliveryTypeId;
	}

	public void setDeliveryTypeId(Integer deliveryTypeId) {
		this.deliveryTypeId = deliveryTypeId;
	}

	@Column(name = "ClassID", nullable = false)
	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Column(name = "Remarks", nullable = false, length = 50)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "deliverytype")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
