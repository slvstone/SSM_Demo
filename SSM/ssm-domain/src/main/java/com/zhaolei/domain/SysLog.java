package com.zhaolei.domain;

import lombok.Data;

import java.util.Date;

/**
 * SSM
 * 2019-05-12 15:56
 *
 * @author leonzhao
 **/

@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

}
