package com.zhaolei.domain;

import lombok.Data;

/**
 * SSM
 * 2019-05-08 14:08
 * 旅客实体类
 * @author leonzhao
 **/

@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private int credentialsType;
    private String credentialsNum;
    private int travellerType;
}
