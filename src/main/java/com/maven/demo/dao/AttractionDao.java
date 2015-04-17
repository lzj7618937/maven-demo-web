package com.maven.demo.dao;

import java.util.List;

import com.maven.common.dao.IBaseDao;
import com.maven.demo.entity.AttractionModel;
import com.maven.demo.entity.AttractionQueryModel;

/**
 * @author jaylee
 *
 */
public interface AttractionDao extends IBaseDao<AttractionModel, Integer>{
	
    List<AttractionModel> query(int pn, int pageSize, AttractionQueryModel command);

    int countQuery(AttractionQueryModel command);
}
