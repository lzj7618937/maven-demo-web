package com.maven.demo.dao.hibernate4;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.maven.common.dao.hibernate4.BaseHibernateDao;
import com.maven.demo.dao.AttractionDao;
import com.maven.demo.entity.AttractionModel;
import com.maven.demo.entity.AttractionQueryModel;

/**
 * @author jaylee
 *
 */
@Repository("AttractionDao")
public class AttractionHibernate4DaoImpl extends BaseHibernateDao<AttractionModel, Integer> implements AttractionDao {

    private static final String HQL_LIST = "from AttractionModel ";
    private static final String HQL_COUNT = "select count(*) from AttractionModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where title like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<AttractionModel> query(int pn, int pageSize, AttractionQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQuery(AttractionQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(AttractionQueryModel command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getTitle() + "%";
        return new Object[]{
            usernameLikeStr
        };
    }

}
