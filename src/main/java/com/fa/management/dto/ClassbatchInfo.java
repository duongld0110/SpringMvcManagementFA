package com.fa.management.dto;

public class ClassbatchInfo {

	private int classId;
	private int classadminID;
	private int classAdminProfileId;
	private String classadminRemarks;
	private int deliverytypeID;
	private int formattypeID;
	private int locationID;
	private String locationName;
	private int partnerID;
	private int scopeID;
	private int subjecttypeID;
	private int subsubjecttypeID;
	private int trainerID;
	private int trainerProfileId;
	private String trainerType;
	private String trainerRemarks;
	private String className;
	private String classCode;
	private String expectedStartDate;
	private String expectedEndDate;
	private String detailLocation;
	private int plannedTraineeNumber;
	private String actualStartDate;
	private String actualEndDate;
	private int acceptedTraineeNumber;
	private int actualTraineeNumber;
	private String milestones;
	private String curriculum;
	private String status;
	private String remarks;

	public ClassbatchInfo() {
	}
	
	public ClassbatchInfo(int classId, String classadminRemarks, String locationName,
			 String trainerRemarks, String className, String classCode, String expectedStartDate,
			String expectedEndDate, String detailLocation, int plannedTraineeNumber, String status, String remarks) {
		super();
		this.classId = classId;
		this.classadminRemarks = classadminRemarks;
		this.locationName = locationName;
		this.trainerRemarks = trainerRemarks;
		this.className = className;
		this.classCode = classCode;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.detailLocation = detailLocation;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.status = status;
		this.remarks = remarks;
	}
	
	public ClassbatchInfo(int classId, int classadminID, String classadminRemarks, int locationID, String locationName,
			int trainerID, String trainerRemarks, String className, String classCode, String expectedStartDate,
			String expectedEndDate, String detailLocation, int plannedTraineeNumber, String status, String remarks) {
		super();
		this.classId = classId;
		this.classadminID = classadminID;
		this.classadminRemarks = classadminRemarks;
		this.locationID = locationID;
		this.locationName = locationName;
		this.trainerID = trainerID;
		this.trainerRemarks = trainerRemarks;
		this.className = className;
		this.classCode = classCode;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.detailLocation = detailLocation;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.status = status;
		this.remarks = remarks;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getClassadminID() {
		return classadminID;
	}

	public void setClassadminID(int classadminID) {
		this.classadminID = classadminID;
	}

	public int getClassAdminProfileId() {
		return classAdminProfileId;
	}

	public void setClassAdminProfileId(int classAdminProfileId) {
		this.classAdminProfileId = classAdminProfileId;
	}

	public String getClassadminRemarks() {
		return classadminRemarks;
	}

	public void setClassadminRemarks(String classadminRemarks) {
		this.classadminRemarks = classadminRemarks;
	}

	public int getDeliverytypeID() {
		return deliverytypeID;
	}

	public void setDeliverytypeID(int deliverytypeID) {
		this.deliverytypeID = deliverytypeID;
	}

	public int getFormattypeID() {
		return formattypeID;
	}

	public void setFormattypeID(int formattypeID) {
		this.formattypeID = formattypeID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}

	public int getScopeID() {
		return scopeID;
	}

	public void setScopeID(int scopeID) {
		this.scopeID = scopeID;
	}

	public int getSubjecttypeID() {
		return subjecttypeID;
	}

	public void setSubjecttypeID(int subjecttypeID) {
		this.subjecttypeID = subjecttypeID;
	}

	public int getSubsubjecttypeID() {
		return subsubjecttypeID;
	}

	public void setSubsubjecttypeID(int subsubjecttypeID) {
		this.subsubjecttypeID = subsubjecttypeID;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public int getTrainerProfileId() {
		return trainerProfileId;
	}

	public void setTrainerProfileId(int trainerProfileId) {
		this.trainerProfileId = trainerProfileId;
	}

	public String getTrainerType() {
		return trainerType;
	}

	public void setTrainerType(String trainerType) {
		this.trainerType = trainerType;
	}

	public String getTrainerRemarks() {
		return trainerRemarks;
	}

	public void setTrainerRemarks(String trainerRemarks) {
		this.trainerRemarks = trainerRemarks;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getExpectedStartDate() {
		return expectedStartDate;
	}

	public void setExpectedStartDate(String expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	public String getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(String expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public String getDetailLocation() {
		return detailLocation;
	}

	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
	}

	public int getPlannedTraineeNumber() {
		return plannedTraineeNumber;
	}

	public void setPlannedTraineeNumber(int plannedTraineeNumber) {
		this.plannedTraineeNumber = plannedTraineeNumber;
	}

	public String getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public int getAcceptedTraineeNumber() {
		return acceptedTraineeNumber;
	}

	public void setAcceptedTraineeNumber(int acceptedTraineeNumber) {
		this.acceptedTraineeNumber = acceptedTraineeNumber;
	}

	public int getActualTraineeNumber() {
		return actualTraineeNumber;
	}

	public void setActualTraineeNumber(int actualTraineeNumber) {
		this.actualTraineeNumber = actualTraineeNumber;
	}

	public String getMilestones() {
		return milestones;
	}

	public void setMilestones(String milestones) {
		this.milestones = milestones;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ClassbatchInfo [classId=" + classId + ", classadminID=" + classadminID + ", classAdminProfileId="
				+ classAdminProfileId + ", classadminRemarks=" + classadminRemarks + ", deliverytypeID="
				+ deliverytypeID + ", formattypeID=" + formattypeID + ", locationID=" + locationID + ", locationName="
				+ locationName + ", partnerID=" + partnerID + ", scopeID=" + scopeID + ", subjecttypeID="
				+ subjecttypeID + ", subsubjecttypeID=" + subsubjecttypeID + ", trainerID=" + trainerID
				+ ", trainerProfileId=" + trainerProfileId + ", trainerType=" + trainerType + ", trainerRemarks="
				+ trainerRemarks + ", className=" + className + ", classCode=" + classCode + ", expectedStartDate="
				+ expectedStartDate + ", expectedEndDate=" + expectedEndDate + ", detailLocation=" + detailLocation
				+ ", plannedTraineeNumber=" + plannedTraineeNumber + ", actualStartDate=" + actualStartDate
				+ ", actualEndDate=" + actualEndDate + ", acceptedTraineeNumber=" + acceptedTraineeNumber
				+ ", actualTraineeNumber=" + actualTraineeNumber + ", milestones=" + milestones + ", curriculum="
				+ curriculum + ", status=" + status + ", remarks=" + remarks + "]";
	}

}
