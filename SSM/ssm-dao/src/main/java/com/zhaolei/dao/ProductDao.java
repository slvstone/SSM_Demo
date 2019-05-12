package com.zhaolei.dao;

import com.zhaolei.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

/**
 * SSM
 * 2019-05-07 18:43
 *
 * @author leonzhao
 **/


public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Update("insert into product values (#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Select("select * from product where id=#{id}")
    Product findById(@Param("id") String id) throws Exception;

    @Update("delete from product where id = #{id}")
    void deleteByid(@Param("id") String id) throws Exception;
}
