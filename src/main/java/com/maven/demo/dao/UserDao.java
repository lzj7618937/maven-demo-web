package com.maven.demo.dao;

import java.util.List;

import com.maven.common.dao.IBaseDao;
import com.maven.demo.entity.UserModel;
import com.maven.demo.entity.UserQueryModel;


public interface UserDao extends IBaseDao<UserModel, Integer> {
    
    List<UserModel> query(int pn, int pageSize, UserQueryModel command);

    int countQuery(UserQueryModel command);

}
