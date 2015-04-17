package com.maven.demo.dao.hibernate4;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.maven.common.dao.hibernate4.BaseHibernateDao;
import com.maven.demo.dao.DayplanDao;
import com.maven.demo.entity.DayplanModel;
import com.maven.demo.entity.DayplanQueryModel;

/**
 * @author jaylee
 *
 */
@Repository("DayplanDao")
public class DayplanHibernate4DaoImpl extends BaseHibernateDao<DayplanModel, Integer>  implements DayplanDao {

    private static final String HQL_LIST = "from DayplanModel ";
    private static final String HQL_COUNT = "select count(*) from DayplanModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where remark like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<DayplanModel> query(int pn, int pageSize, DayplanQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQuery(DayplanQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(DayplanQueryModel command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getRemark() + "%";
        return new Object[]{
            usernameLikeStr
        };
    }
}
