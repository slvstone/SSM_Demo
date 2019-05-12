package com.zhaolei.controller;

import com.github.pagehelper.PageInfo;
import com.zhaolei.domain.Order;
import com.zhaolei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * SSM
 * 2019-05-08 11:57
 * 订单控制器
 * @author leonzhao
 **/

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    //未分页findAll.do
/*    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        List<Order> ordersList = ordersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-list");
        mv.addObject("ordersList", ordersList);
        return mv;
    }*/
    //分页findAll.do
    @RequestMapping("/findAll.do")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") int pageSize) throws Exception{
        List<Order> ordersList = ordersService.findAllByPage(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name="id") String orderId) throws Exception{
        Order order = ordersService.findById(orderId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }


}
