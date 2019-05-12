package com.zhaolei.dao;

import com.zhaolei.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * SSM
 * 2019-05-09 23:29
 *
 * @author leonzhao
 **/

public interface RoleDao {

    /**
     * 根据用户名称查询相关角色信息和权限信息
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in(select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
            many = @Many(select = "com.zhaolei.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 根据用户信息查询 可添加的角色及权限信息
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id not in(select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.zhaolei.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findAddRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Insert("insert into role (roleName, roleDesc) values (#{roleName}, #{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 根据角色id查询 角色信息及可添加的权限信息
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.zhaolei.dao.PermissionDao.findAddPermissionByRoleId"))
    })
    Role findRoleAndPermissionById(@Param("roleId") String roleId) throws Exception;

    /**
     * 根据角色id 添加相关权限
     * @param roleId
     * @param permission
     * @throws Exception
     */
    @Insert("insert into ROLE_PERMISSION values (#{permissionId}, #{roleId})")
    void addPermissionToRole(@Param("roleId")String roleId, @Param("permissionId") String permission) throws Exception;
}
