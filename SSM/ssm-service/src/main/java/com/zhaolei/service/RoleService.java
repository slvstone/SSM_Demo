package com.zhaolei.service;

import com.zhaolei.domain.Role;

import java.util.List;

/**
 * SSM
 * 2019-05-10 14:21
 *
 * @author leonzhao
 **/

public interface RoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findRoleAndPermissionById(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissions) throws Exception;
}
