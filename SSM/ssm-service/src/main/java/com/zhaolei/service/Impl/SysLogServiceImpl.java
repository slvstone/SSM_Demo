package com.zhaolei.service.Impl;

import com.zhaolei.dao.SysLogDao;
import com.zhaolei.domain.SysLog;
import com.zhaolei.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SSM
 * 2019-05-12 17:00
 *
 * @author leonzhao
 **/

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);

    }
}
