package com.zhaolei.service.Impl;

import com.zhaolei.dao.UserDao;
import com.zhaolei.domain.Role;
import com.zhaolei.domain.UserInfo;
import com.zhaolei.service.UserService;
import com.zhaolei.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * SSM
 * 2019-05-09 22:29
 *
 * @author leonzhao
 **/

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //自己的UserInfo封装成UserDetails 账户停用过滤/权限获取
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true,
                true, true, true, getAuthority(userInfo.getRoles()));

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception {

        List<UserInfo> users = userDao.findAll();

        return users;

    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword()));
        userDao.save(userInfo);

    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);

    }

    @Override
    public UserInfo findRolesByUserId(String userid) throws Exception {
        return userDao.findUserAndAddRoleById(userid);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception{
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }
}
