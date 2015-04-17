package com.maven.demo.service.impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.maven.common.dao.IBaseDao;
import com.maven.common.pagination.Page;
import com.maven.common.pagination.PageUtil;
import com.maven.common.service.impl.BaseService;
import com.maven.demo.dao.DayplanDao;
import com.maven.demo.entity.DayplanModel;
import com.maven.demo.entity.DayplanQueryModel;
import com.maven.demo.service.DayplanService;

/**
 * @author jaylee
 *
 */
@Service("DayplanService")
public class DayplanServiceImpl extends BaseService<DayplanModel, Integer> implements
		DayplanService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AttractionServiceImpl.class);

    @Autowired
    @Qualifier("DayplanDao")
    private DayplanDao dayplanDao;
    
    @Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

    @Override
    public void setBaseDao(IBaseDao<DayplanModel, Integer> dayplanDao) {
        this.baseDao = dayplanDao;
        this.dayplanDao = (DayplanDao) dayplanDao;
    }
    
    @Override
    public Page<DayplanModel> query(int pn, int pageSize, DayplanQueryModel command) {
        return PageUtil.getPage(dayplanDao.countQuery(command) ,pn, dayplanDao.query(pn, pageSize, command), pageSize);
    }
    
//    @Override
//    public void delete(int id){
//    	Session s = sessionFactory.openSession();
//    	Transaction tx = s.beginTransaction(); //打开事务（针对读数据库）
//    	String hql="delete from DayplanModel  g where g.id=1";//准备hql
//    	//sessionFactory.openSession().delete(id);
//    	s.createQuery(hql).executeUpdate();//更新
//    	tx.commit();//提交事务
//    	s.close(); //关闭session
//    }

}
