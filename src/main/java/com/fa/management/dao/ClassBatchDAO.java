package com.fa.management.dao;

import java.util.List;

import com.fa.management.dto.ClassbatchInfo;
import com.fa.management.dto.PaginationResult;
import com.fa.management.entity.Classbatch;

public interface ClassBatchDAO {

	public Classbatch saveOrUpdateClassBatch(ClassbatchInfo classbatchInfo);

	public Classbatch findClassBatchByID(int id);

	public ClassbatchInfo findClassbatchInfoByID(int id);

	public List<ClassbatchInfo> getAllClassbatchInfo();

	public PaginationResult<ClassbatchInfo> listClassBatchInfo(int page, int maxResult, int maxNavigationPage);

	public PaginationResult<ClassbatchInfo> listClassBatchInfoForSearch(int page, int maxResult, int maxNavigationPage,
			int locationID, String classCode, String fromDate, String toDate, String status);
}
