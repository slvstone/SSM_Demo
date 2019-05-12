package com.zhaolei.domain;

import lombok.Data;

import java.util.List;

/**
 * SSM
 * 2019-05-09 15:13
 *
 * @author leonzhao
 **/

@Data
public class UserInfo {

    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private List<Role> roles;

}
