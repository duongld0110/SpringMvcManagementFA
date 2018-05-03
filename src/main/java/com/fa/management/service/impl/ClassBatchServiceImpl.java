package com.fa.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.management.dao.ClassBatchDAO;
import com.fa.management.dto.ClassbatchInfo;
import com.fa.management.dto.PaginationResult;
import com.fa.management.entity.Classbatch;
import com.fa.management.service.ClassBatchService;

@Service
@Transactional
public class ClassBatchServiceImpl implements ClassBatchService{

	@Autowired
	private ClassBatchDAO classBatchDAO;
	
	public Classbatch saveOrUpdateClassBatch(ClassbatchInfo classbatchInfo) {
		return classBatchDAO.saveOrUpdateClassBatch(classbatchInfo);
	}

	public Classbatch findClassBatchByID(int id) {
		return classBatchDAO.findClassBatchByID(id);
	}

	public ClassbatchInfo findClassbatchInfoByID(int id) {
		return classBatchDAO.findClassbatchInfoByID(id);
	}

	public List<ClassbatchInfo> getAllClassbatchInfo() {
		return classBatchDAO.getAllClassbatchInfo();
	}

	public PaginationResult<ClassbatchInfo> listClassBatchInfo(int page, int maxResult, int maxNavigationPage) {
		// TODO Auto-generated method stub
		return classBatchDAO.listClassBatchInfo(page, maxResult, maxNavigationPage);
	}

	public PaginationResult<ClassbatchInfo> listClassBatchInfoForSearch(int page, int maxResult, int maxNavigationPage,
			int locationID, String classCode, String fromDate, String toDate, String status) {
		// TODO Auto-generated method stub
		return classBatchDAO.listClassBatchInfoForSearch(page, maxResult, maxNavigationPage, locationID, classCode, fromDate, toDate, status);
	}


	
}
