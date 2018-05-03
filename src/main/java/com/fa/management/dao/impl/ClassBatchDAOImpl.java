package com.fa.management.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fa.management.dao.ClassBatchDAO;
import com.fa.management.dto.ClassbatchInfo;
import com.fa.management.dto.PaginationResult;
import com.fa.management.entity.Classadmin;
import com.fa.management.entity.Classbatch;
import com.fa.management.entity.Deliverytype;
import com.fa.management.entity.Formattype;
import com.fa.management.entity.Location;
import com.fa.management.entity.Partner;
import com.fa.management.entity.Scope;
import com.fa.management.entity.Subjecttype;
import com.fa.management.entity.Subsubjecttype;
import com.fa.management.entity.Trainer;

@Repository
public class ClassBatchDAOImpl implements ClassBatchDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private StringBuilder sbSQL;
	
	@SuppressWarnings("unchecked")
	public List<ClassbatchInfo> getAllClassbatchInfo() {
		String s = "SELECT new " + ClassbatchInfo.class.getName() + "(cb.classId, ca.remarks,  l.locationName,"
				+ " t.remarks, cb.className, cb.classCode, cb.expectedStartDate, cb.expectedEndDate,"
				+ "	cb.detailLocation, cb.plannedTraineeNumber, cb.status, cb.remarks) from "
				+ Classbatch.class.getName() + " cb JOIN cb.classadmin ca JOIN cb.location l JOIN cb.trainer t";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(s);
		return query.list();
	}

	public Classbatch findClassBatchByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Classbatch classbatch = (Classbatch) session.load(Classbatch.class, id);
		return classbatch;
	}

	public ClassbatchInfo findClassbatchInfoByID(int id) {
		Classbatch classbatch = findClassBatchByID(id);
		ClassbatchInfo classbatchInfo = new ClassbatchInfo();
		classbatchInfo.setClassId(classbatch.getClassId());
		classbatchInfo.setClassName(classbatch.getClassName());
		classbatchInfo.setClassCode(classbatch.getClassCode());
		classbatchInfo.setExpectedStartDate(classbatch.getExpectedStartDate());
		classbatchInfo.setExpectedEndDate(classbatch.getExpectedEndDate());
		classbatchInfo.setRemarks(classbatch.getRemarks());
		classbatchInfo.setPlannedTraineeNumber(classbatch.getPlannedTraineeNumber());
		classbatchInfo.setDetailLocation(classbatch.getDetailLocation());
		classbatchInfo.setClassadminID(classbatch.getClassadmin().getClassAdminId());
		classbatchInfo.setLocationID(classbatch.getLocation().getLocationId());
		return classbatchInfo;
	}

	public Classbatch saveOrUpdateClassBatch(ClassbatchInfo classbatchInfo) {
		int id = classbatchInfo.getClassId();
		Classbatch classbatch = null;
		if (id > 0) {
			classbatch = findClassBatchByID(id);
		}
		boolean isNew = false;
		if (classbatch == null) {
			isNew = true;
			classbatch = new Classbatch();
		}
		classbatch.setClassName(classbatchInfo.getClassName());
		classbatch.setClassCode(classbatchInfo.getClassCode());

		Classadmin classadmin = new Classadmin();
		classadmin.setClassAdminId(classbatchInfo.getClassadminID());
		classbatch.setClassadmin(classadmin);

		Deliverytype deliverytype = new Deliverytype();
		deliverytype.setDeliveryTypeId(1);
		classbatch.setDeliverytype(deliverytype);

		Formattype formattype = new Formattype();
		formattype.setFormatTypeId(1);
		classbatch.setFormattype(formattype);

		Location location = new Location();
		location.setLocationId(classbatchInfo.getLocationID());
		classbatch.setLocation(location);

		Partner partner = new Partner();
		partner.setPartnerId(1);
		classbatch.setPartner(partner);

		Scope scope = new Scope();
		scope.setScopeId(1);
		classbatch.setScope(scope);

		Subjecttype subjecttype = new Subjecttype();
		subjecttype.setSubjectTypeId(1);
		classbatch.setSubjecttype(subjecttype);

		Subsubjecttype subsubjecttype = new Subsubjecttype();
		subsubjecttype.setSubSubjectTypeId(1);
		classbatch.setSubsubjecttype(subsubjecttype);

		Trainer trainer = new Trainer();
		trainer.setTrainerId(1);
		classbatch.setTrainer(trainer);

		classbatch.setExpectedStartDate(classbatchInfo.getExpectedStartDate());
		classbatch.setExpectedEndDate(classbatchInfo.getExpectedEndDate());
		classbatch.setDetailLocation(classbatchInfo.getDetailLocation());

		classbatch.setPlannedTraineeNumber(classbatchInfo.getPlannedTraineeNumber());
		classbatch.setStatus("status");
		classbatch.setRemarks(classbatchInfo.getRemarks());
		if (isNew) {
			Session session = sessionFactory.getCurrentSession();
			session.save(classbatch);
		}
		return classbatch;
	}

	public PaginationResult<ClassbatchInfo> listClassBatchInfo(int page, int maxResult, int maxNavigationPage) {
		sbSQL = new StringBuilder();
		sbSQL.append("SELECT new ");
		sbSQL.append(ClassbatchInfo.class.getName());
		sbSQL.append("(cb.classId, ca.remarks, l.locationName, t.remarks, cb.className, ");
		sbSQL.append(" cb.classCode, cb.expectedStartDate, cb.expectedEndDate, ");
		sbSQL.append("	cb.detailLocation, cb.plannedTraineeNumber, cb.status, cb.remarks) FROM ");
		sbSQL.append(Classbatch.class.getName());
		sbSQL.append(" cb JOIN cb.classadmin ca JOIN cb.location l JOIN cb.trainer t ORDER BY cb.classId ASC");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sbSQL.toString());
		return new PaginationResult<ClassbatchInfo>(query, page, maxResult, maxNavigationPage);
	}

	public PaginationResult<ClassbatchInfo> listClassBatchInfoForSearch(int page, int maxResult, int maxNavigationPage,
			int locationID, String classCode, String fromDate, String toDate, String status) {
		sbSQL = new StringBuilder();
		sbSQL.append("SELECT new ");
		sbSQL.append(ClassbatchInfo.class.getName());
		sbSQL.append("(cb.classId, ca.remarks, l.locationName, t.remarks, cb.className, ");
		sbSQL.append(" cb.classCode, cb.expectedStartDate, cb.expectedEndDate, ");
		sbSQL.append("	cb.detailLocation, cb.plannedTraineeNumber, cb.status, cb.remarks) FROM ");
		sbSQL.append(Classbatch.class.getName());
		sbSQL.append(" cb JOIN cb.classadmin ca JOIN cb.location l JOIN cb.trainer t ");
		sbSQL.append(" WHERE l.locationId = :locationID ");
		if (classCode != null && classCode.length() > 0) {
			sbSQL.append(" AND cb.classCode = :classCode ");
		}
		if (fromDate != null && fromDate.length() > 0 && toDate != null && toDate.length() > 0) {
			sbSQL.append(" AND cb.expectedStartDate >= :fromDate AND  cb.expectedEndDate <= :toDate ");
		}
		if (status != null && status.length() > 0) {
			sbSQL.append(" AND cb.status = :status ");
		}
		sbSQL.append(" ORDER BY cb.classId ASC");

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sbSQL.toString());
		query.setParameter("locationID", locationID);
		if (classCode != null && classCode.length() > 0) {
			query.setParameter("classCode", classCode);
		}
		if (fromDate != null && fromDate.length() > 0 && toDate != null && toDate.length() > 0) {
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
		}
		if (status != null && status.length() > 0) {
			query.setParameter("status", status);
		}
		return new PaginationResult<ClassbatchInfo>(query, page, maxResult, maxNavigationPage);
	}

}
