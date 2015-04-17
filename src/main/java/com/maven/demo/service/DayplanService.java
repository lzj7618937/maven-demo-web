package com.maven.demo.service;

import com.maven.common.pagination.Page;
import com.maven.common.service.IBaseService;
import com.maven.demo.entity.DayplanModel;
import com.maven.demo.entity.DayplanQueryModel;

public interface DayplanService extends IBaseService<DayplanModel, Integer> {
	Page<DayplanModel> query(int pn, int pageSize, DayplanQueryModel command);

//	void delete(int id);
}
