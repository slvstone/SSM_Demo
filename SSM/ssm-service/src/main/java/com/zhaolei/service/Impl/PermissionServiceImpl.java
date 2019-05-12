package com.zhaolei.service.Impl;

import com.zhaolei.dao.PermissionDao;
import com.zhaolei.domain.Permission;
import com.zhaolei.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SSM
 * 2019-05-10 14:21
 *
 * @author leonzhao
 **/

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
