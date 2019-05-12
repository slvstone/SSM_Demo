package com.zhaolei.dao;

import com.zhaolei.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * SSM
 * 2019-05-09 09:50
 *
 * @author leonzhao
 **/

public interface MemberDao {

    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;
}
