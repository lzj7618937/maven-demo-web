package com.maven.demo.dao;

import java.util.List;

import com.maven.common.dao.IBaseDao;
import com.maven.demo.entity.DayplanModel;
import com.maven.demo.entity.DayplanQueryModel;

/**
 * @author jaylee
 *
 */
public interface DayplanDao extends IBaseDao<DayplanModel, Integer> {
	List<DayplanModel> query(int pn, int pageSize, DayplanQueryModel command);

	int countQuery(DayplanQueryModel command);
}
