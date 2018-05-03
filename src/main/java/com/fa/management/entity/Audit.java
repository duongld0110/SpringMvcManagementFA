package com.fa.management.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "audit", catalog = "fa_g1")
public class Audit implements java.io.Serializable {

	private static final long serialVersionUID = -3760233469552324703L;
	private Integer auditId;
	private Classbatch classbatch;
	private Date date;
	private String eventCategory;
	private String relatedPartyPeople;
	private String action;
	private String pic;
	private String deadline;
	private String note;

	public Audit() {
	}

	public Audit(Classbatch classbatch) {
		this.classbatch = classbatch;
	}

	public Audit(Classbatch classbatch, Date date, String eventCategory, String relatedPartyPeople, String action,
			String pic, String deadline, String note) {
		this.classbatch = classbatch;
		this.date = date;
		this.eventCategory = eventCategory;
		this.relatedPartyPeople = relatedPartyPeople;
		this.action = action;
		this.pic = pic;
		this.deadline = deadline;
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "AuditID", unique = true, nullable = false)
	public Integer getAuditId() {
		return this.auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ClassID", nullable = false)
	public Classbatch getClassbatch() {
		return this.classbatch;
	}

	public void setClassbatch(Classbatch classbatch) {
		this.classbatch = classbatch;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "EventCategory", length = 50)
	public String getEventCategory() {
		return this.eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	@Column(name = "RelatedPartyPeople", length = 50)
	public String getRelatedPartyPeople() {
		return this.relatedPartyPeople;
	}

	public void setRelatedPartyPeople(String relatedPartyPeople) {
		this.relatedPartyPeople = relatedPartyPeople;
	}

	@Column(name = "Action", length = 50)
	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Column(name = "PIC", length = 50)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "Deadline", length = 50)
	public String getDeadline() {
		return this.deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@Column(name = "Note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
