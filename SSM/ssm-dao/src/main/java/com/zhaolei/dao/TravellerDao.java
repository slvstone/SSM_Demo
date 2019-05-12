package com.zhaolei.dao;

import com.zhaolei.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * SSM
 * 2019-05-09 09:55
 *
 * @author leonzhao
 **/

public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findByOrderId (String orderId) throws Exception;
}
