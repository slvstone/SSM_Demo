package com.zhaolei.service;

import com.zhaolei.domain.Order;
import com.zhaolei.domain.Product;

import java.util.List;

/**
 * SSM
 * 2019-05-07 18:41
 *
 * @author leonzhao
 **/

public interface OrdersService {

    List<Order> findAll() throws Exception;

    void save(Order order) throws Exception;

    List<Order> findAllByPage(int page, int pageSize) throws Exception;

    Order findById(String id) throws Exception;
}
