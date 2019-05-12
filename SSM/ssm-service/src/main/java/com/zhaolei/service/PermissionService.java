package com.zhaolei.service;

import com.zhaolei.domain.Permission;


import java.util.List;

/**
 * SSM
 * 2019-05-10 15:04
 *
 * @author leonzhao
 **/

public interface PermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
