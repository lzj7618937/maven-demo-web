package com.maven.demo.service;

import com.maven.common.pagination.Page;
import com.maven.common.service.IBaseService;
import com.maven.demo.entity.UserModel;
import com.maven.demo.entity.UserQueryModel;

/**
 * User: Zhang Kaitao
 * Date: 12-1-4 上午10:13
 * Version: 1.0
 */
public interface UserService extends IBaseService<UserModel, Integer> {

    Page<UserModel> query(int pn, int pageSize, UserQueryModel command);
}
