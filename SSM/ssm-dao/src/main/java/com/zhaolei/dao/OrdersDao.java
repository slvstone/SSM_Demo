package com.zhaolei.dao;

import com.zhaolei.domain.Member;
import com.zhaolei.domain.Order;
import com.zhaolei.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * SSM
 * 2019-05-08 14:25
 *
 * @author leonzhao
 **/

public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.zhaolei.dao.ProductDao.findById"))

    })
    List<Order> findAll() throws Exception;


    @Update("insert into orders values (#{id},#{orderNum},#{orderTime},#{orderStatus},#{peopleCount},#{product.id},#{member.id})")
    void save(Order order);

    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.zhaolei.dao.ProductDao.findById"))

    })
    List<Order> findAllByPage() throws Exception;

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.zhaolei.dao.ProductDao.findById")),
            @Result(column = "memberId", property = "member", javaType = Member.class,
                    one = @One(select = "com.zhaolei.dao.MemberDao.findById")),
            @Result(column = "id", property = "travellers", javaType = java.util.List.class,
                    many = @Many(select = "com.zhaolei.dao.TravellerDao.findByOrderId"))
    })
    Order findById(@Param("id") String id) throws Exception;

}
