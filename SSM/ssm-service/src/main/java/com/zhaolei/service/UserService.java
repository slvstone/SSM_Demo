package com.zhaolei.service;

import com.zhaolei.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * SSM
 * 2019-05-09 22:28
 *
 * @author leonzhao
 **/

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;


    UserInfo findRolesByUserId(String userid) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
