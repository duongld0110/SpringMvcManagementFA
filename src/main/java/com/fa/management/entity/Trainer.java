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
@Table(name = "trainer", catalog = "fa_g1")
public class Trainer implements java.io.Serializable {
	private static final long serialVersionUID = -857211126353517650L;
	private Integer trainerId;
	private int classId;
	private int trainerProfileId;
	private String type;
	private String remarks;
	private Set<Classbatch> classbatches = new HashSet<Classbatch>(0);

	public Trainer() {
	}

	public Trainer(int classId, int trainerProfileId) {
		this.classId = classId;
		this.trainerProfileId = trainerProfileId;
	}

	public Trainer(int classId, int trainerProfileId, String type, String remarks, Set<Classbatch> classbatches) {
		this.classId = classId;
		this.trainerProfileId = trainerProfileId;
		this.type = type;
		this.remarks = remarks;
		this.classbatches = classbatches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TrainerID", unique = true, nullable = false)
	public Integer getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	@Column(name = "ClassID", nullable = false)
	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Column(name = "TrainerProfileID", nullable = false)
	public int getTrainerProfileId() {
		return this.trainerProfileId;
	}

	public void setTrainerProfileId(int trainerProfileId) {
		this.trainerProfileId = trainerProfileId;
	}

	@Column(name = "Type", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "Remarks", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
	public Set<Classbatch> getClassbatches() {
		return this.classbatches;
	}

	public void setClassbatches(Set<Classbatch> classbatches) {
		this.classbatches = classbatches;
	}

}
