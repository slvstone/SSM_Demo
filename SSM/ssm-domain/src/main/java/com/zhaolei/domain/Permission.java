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
public class Permission {

    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
