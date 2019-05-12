package com.zhaolei.service.Impl;

import com.github.pagehelper.PageHelper;
import com.zhaolei.dao.OrdersDao;
import com.zhaolei.domain.Order;
import com.zhaolei.domain.Product;
import com.zhaolei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SSM
 * 2019-05-08 14:24
 *
 * @author leonzhao
 **/
@Transactional
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Order> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public void save(Order order) {
        ordersDao.save(order);
    }

    @Override
    public List<Order> findAllByPage(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Order findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
