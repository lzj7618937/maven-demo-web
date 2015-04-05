package com.maven.common.model;

import com.maven.common.service.ICommonService;
import com.maven.common.util.SpringContextUtil;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Zhang Kaitao
 * @version 1.0, 2010-8-12
 */
public abstract class AbstractModel implements java.io.Serializable {

    private static final long serialVersionUID = 2035013017939483936L;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    public void save() {
        ICommonService commonService = SpringContextUtil.getBean("CommonService");
        commonService.save(this);
    }

    public void delete() {
        ICommonService commonService = SpringContextUtil.getBean("CommonService");
        commonService.deleteObject(this);
    }

    public void update() {
        ICommonService commonService = SpringContextUtil.getBean("CommonService");
        commonService.update(this);
    }
}
