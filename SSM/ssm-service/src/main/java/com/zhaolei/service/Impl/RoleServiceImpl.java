package com.zhaolei.service.Impl;

import com.zhaolei.dao.RoleDao;
import com.zhaolei.domain.Role;
import com.zhaolei.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public List<Role> findAll() throws Exception{
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findRoleAndPermissionById (String roleId) throws Exception{
        return roleDao.findRoleAndPermissionById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissions) throws Exception{
        for (String permission : permissions) {
            roleDao.addPermissionToRole(roleId, permission);
        }
    }
}
