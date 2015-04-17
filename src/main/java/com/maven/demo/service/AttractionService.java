package com.maven.demo.service;

import com.maven.common.pagination.Page;
import com.maven.common.service.IBaseService;
import com.maven.demo.entity.AttractionModel;
import com.maven.demo.entity.AttractionQueryModel;

/**
 * @author jaylee
 *
 */
public interface AttractionService extends IBaseService<AttractionModel, Integer> {

    Page<AttractionModel> query(int pn, int pageSize, AttractionQueryModel command);
}
