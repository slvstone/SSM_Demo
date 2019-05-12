package com.zhaolei.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * SSM
 * 2019-05-08 11:38
 * 订单实体类
 * @author leonzhao
 **/

@Data
public class Order {

    private String id;
    private String orderNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;
    private int peopleCount;
    private String orderDesc;
    private int payType;
    private int orderStatus;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
}
