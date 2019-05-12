package com.zhaolei.dao;

import com.zhaolei.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

/**
 * SSM
 * 2019-05-12 17:02
 *
 * @author leonzhao
 **/

public interface SysLogDao {

    @Insert("insert into syslog (visitTime, username, ip, url, executionTime, method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;
}
