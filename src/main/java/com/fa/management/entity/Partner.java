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
@Table(name = "partner", catalog = "fa_g1")
public class Partner implements java.io.Serializable {
	private static final long serialVersionUID = 6426741179075577485L;
	private Integer partnerId;
	private String remarks;
	private String partnerName;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Partner() {
	}

	public Partner(String remarks, String partnerName) {
		this.remarks = remarks;
		this.partnerName = partnerName;
	}

	public Partner(String remarks, String partnerName, Set<Classbatch> classbatches) {
		this.remarks = remarks;
		this.partnerName = partnerName;
		this.classbatches = classbatches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PartnerID", unique = true, nullable = false)
	public Integer getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	@Column(name = "Remarks", nullable = false, length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "PartnerName", nullable = false, length = 50)
	public String getPartnerName() {
		return this.partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
