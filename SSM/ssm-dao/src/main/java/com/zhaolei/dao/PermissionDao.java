package com.zhaolei.dao;

import com.zhaolei.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * SSM
 * 2019-05-10 11:15
 *
 * @author leonzhao
 **/

public interface PermissionDao {

    @Select("select * from permission where id in (select permissionid from role_permission where roleId = #{roleId})")
    List<Permission> findByRoleId(String roleId) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;


    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id not in (select permissionid from role_permission where roleId = #{roleId})")
    List<Permission> findAddPermissionByRoleId (String roleId) throws Exception;
}
