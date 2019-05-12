package com.zhaolei.dao;

import com.zhaolei.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * SSM
 * 2019-05-09 15:12
 *
 * @author leonzhao
 **/

public interface UserDao {

    /**
     * 根据用户名查询用户及角色和权限信息
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id=true,property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
            many = @Many(select = "com.zhaolei.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 添加新用户
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users (username, email, password, phoneNum, status) values (#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户id查找到角色 连表查询该用户的角色信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id=true,property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.zhaolei.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id) throws Exception;


    /**
     * 根据userid查询出用户信息 连表查出可添加的角色信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id=true,property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.zhaolei.dao.RoleDao.findAddRoleByUserId"))
    })
    UserInfo findUserAndAddRoleById(String id) throws Exception;

    /**
     * 根据用户id添加角色信息
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId")String roleId) throws Exception;
}
