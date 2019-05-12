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
public class Role {

    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;
}
