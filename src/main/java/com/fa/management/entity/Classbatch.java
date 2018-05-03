package com.fa.management.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "classbatch", catalog = "fa_g1")
public class Classbatch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6970472451442789221L;
	private Integer classId;
	private Classadmin classadmin;
	private Deliverytype deliverytype;
	private Formattype formattype;
	private Location location;
	private Partner partner;
	private Scope scope;
	private Subjecttype subjecttype;
	private Subsubjecttype subsubjecttype;
	private Trainer trainer;
	private String className;
	private String classCode;
	private String expectedStartDate;
	private String expectedEndDate;
	private String detailLocation;
	private int plannedTraineeNumber;
	private String actualStartDate;
	private String actualEndDate;
	private Integer acceptedTraineeNumber;
	private Integer actualTraineeNumber;
	private String milestones;
	private String curriculum;
	private String status;
	private String remarks;
	private Set<Audit> audits = new HashSet<Audit>(0);

	public Classbatch() {
	}

	public Classbatch(Classadmin classadmin, Deliverytype deliverytype, Formattype formattype, Location location,
			Partner partner, Scope scope, Subjecttype subjecttype, Subsubjecttype subsubjecttype, Trainer trainer,
			String className, String classCode, String expectedEndDate, String detailLocation, int plannedTraineeNumber,
			String status) {
		this.classadmin = classadmin;
		this.deliverytype = deliverytype;
		this.formattype = formattype;
		this.location = location;
		this.partner = partner;
		this.scope = scope;
		this.subjecttype = subjecttype;
		this.subsubjecttype = subsubjecttype;
		this.trainer = trainer;
		this.className = className;
		this.classCode = classCode;
		this.expectedEndDate = expectedEndDate;
		this.detailLocation = detailLocation;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.status = status;
	}

	public Classbatch(Classadmin classadmin, Deliverytype deliverytype, Formattype formattype, Location location,
			Partner partner, Scope scope, Subjecttype subjecttype, Subsubjecttype subsubjecttype, Trainer trainer,
			String className, String classCode, String expectedStartDate, String expectedEndDate, String detailLocation,
			int plannedTraineeNumber, String actualStartDate, String actualEndDate, Integer acceptedTraineeNumber,
			Integer actualTraineeNumber, String milestones, String curriculum, String status, String remarks,
			Set<Audit> audits) {
		this.classadmin = classadmin;
		this.deliverytype = deliverytype;
		this.formattype = formattype;
		this.location = location;
		this.partner = partner;
		this.scope = scope;
		this.subjecttype = subjecttype;
		this.subsubjecttype = subsubjecttype;
		this.trainer = trainer;
		this.className = className;
		this.classCode = classCode;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.detailLocation = detailLocation;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.acceptedTraineeNumber = acceptedTraineeNumber;
		this.actualTraineeNumber = actualTraineeNumber;
		this.milestones = milestones;
		this.curriculum = curriculum;
		this.status = status;
		this.remarks = remarks;
		this.audits = audits;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ClassID", unique = true, nullable = false)
	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ClassAdminID", nullable = false)
	public Classadmin getClassadmin() {
		return this.classadmin;
	}

	public void setClassadmin(Classadmin classadmin) {
		this.classadmin = classadmin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeliveryTypeID", nullable = false)
	public Deliverytype getDeliverytype() {
		return this.deliverytype;
	}

	public void setDeliverytype(Deliverytype deliverytype) {
		this.deliverytype = deliverytype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FormatTypeID", nullable = false)
	public Formattype getFormattype() {
		return this.formattype;
	}

	public void setFormattype(Formattype formattype) {
		this.formattype = formattype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LocationID", nullable = false)
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PartnerID", nullable = false)
	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ScopeID", nullable = false)
	public Scope getScope() {
		return this.scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubjectTypeID", nullable = false)
	public Subjecttype getSubjecttype() {
		return this.subjecttype;
	}

	public void setSubjecttype(Subjecttype subjecttype) {
		this.subjecttype = subjecttype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubSubjectTypeID", nullable = false)
	public Subsubjecttype getSubsubjecttype() {
		return this.subsubjecttype;
	}

	public void setSubsubjecttype(Subsubjecttype subsubjecttype) {
		this.subsubjecttype = subsubjecttype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TrainerID", nullable = false)
	public Trainer getTrainer() {
		return this.trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Column(name = "ClassName", nullable = false, length = 50)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "ClassCode", nullable = false, length = 40)
	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	@Column(name = "ExpectedStartDate", length = 40)
	public String getExpectedStartDate() {
		return this.expectedStartDate;
	}

	public void setExpectedStartDate(String expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	@Column(name = "ExpectedEndDate", nullable = false, length = 40)
	public String getExpectedEndDate() {
		return this.expectedEndDate;
	}

	public void setExpectedEndDate(String expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	@Column(name = "DetailLocation", nullable = false, length = 50)
	public String getDetailLocation() {
		return this.detailLocation;
	}

	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
	}

	@Column(name = "PlannedTraineeNumber", nullable = false)
	public int getPlannedTraineeNumber() {
		return this.plannedTraineeNumber;
	}

	public void setPlannedTraineeNumber(int plannedTraineeNumber) {
		this.plannedTraineeNumber = plannedTraineeNumber;
	}

	@Column(name = "ActualStartDate", length = 40)
	public String getActualStartDate() {
		return this.actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	@Column(name = "ActualEndDate", length = 40)
	public String getActualEndDate() {
		return this.actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	@Column(name = "AcceptedTraineeNumber")
	public Integer getAcceptedTraineeNumber() {
		return this.acceptedTraineeNumber;
	}

	public void setAcceptedTraineeNumber(Integer acceptedTraineeNumber) {
		this.acceptedTraineeNumber = acceptedTraineeNumber;
	}

	@Column(name = "ActualTraineeNumber")
	public Integer getActualTraineeNumber() {
		return this.actualTraineeNumber;
	}

	public void setActualTraineeNumber(Integer actualTraineeNumber) {
		this.actualTraineeNumber = actualTraineeNumber;
	}

	@Column(name = "Milestones", length = 50)
	public String getMilestones() {
		return this.milestones;
	}

	public void setMilestones(String milestones) {
		this.milestones = milestones;
	}

	@Column(name = "Curriculum", length = 50)
	public String getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	@Column(name = "Status", nullable = false, length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "Remarks", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classbatch")
	public Set<Audit> getAudits() {
		return this.audits;
	}

	public void setAudits(Set<Audit> audits) {
		this.audits = audits;
	}

}
