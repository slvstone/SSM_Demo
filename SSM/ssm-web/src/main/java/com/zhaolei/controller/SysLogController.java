package com.zhaolei.controller;

import com.zhaolei.domain.SysLog;
import com.zhaolei.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * SSM
 * 2019-05-12 18:54
 *
 * @author leonzhao
 **/
@Controller
@RequestMapping ("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll();
        mv.addObject("sysLogs", sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }

}
