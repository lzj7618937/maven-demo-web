package com.maven.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.maven.common.dao.IBaseDao;
import com.maven.common.pagination.Page;
import com.maven.common.pagination.PageUtil;
import com.maven.common.service.impl.BaseService;
import com.maven.demo.dao.AttractionDao;
import com.maven.demo.entity.AttractionModel;
import com.maven.demo.entity.AttractionQueryModel;
import com.maven.demo.service.AttractionService;

/**
 * @author jaylee
 *
 */
@Service("AttractionService")
public class AttractionServiceImpl extends BaseService<AttractionModel, Integer> implements AttractionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttractionServiceImpl.class);

    private AttractionDao attractionDao;

    @Autowired
    @Qualifier("AttractionDao")
    @Override
    public void setBaseDao(IBaseDao<AttractionModel, Integer> attractionDao) {
        this.baseDao = attractionDao;
        this.attractionDao = (AttractionDao) attractionDao;
    }
    
    @Override
    public Page<AttractionModel> query(int pn, int pageSize, AttractionQueryModel command) {
        return PageUtil.getPage(attractionDao.countQuery(command) ,pn, attractionDao.query(pn, pageSize, command), pageSize);
    }
   
}