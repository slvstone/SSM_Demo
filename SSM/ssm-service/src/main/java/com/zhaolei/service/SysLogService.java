package com.zhaolei.service;

import com.zhaolei.domain.SysLog;

/**
 * SSM
 * 2019-05-12 16:59
 *
 * @author leonzhao
 **/

public interface SysLogService {
    void save(SysLog sysLog) throws Exception;
}
