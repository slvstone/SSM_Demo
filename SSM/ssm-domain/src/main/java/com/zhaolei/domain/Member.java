package com.zhaolei.domain;

import lombok.Data;

/**
 * SSM
 * 2019-05-08 11:43
 * 会员实体类
 * @author leonzhao
 **/

@Data
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
