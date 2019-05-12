package com.zhaolei.controller;

import com.zhaolei.domain.SysLog;
import com.zhaolei.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * SSM 利用AOP切面进行日志处理
 * 2019-05-12 16:00
 *
 * @author leonzhao
 **/


@Component
@Aspect
public class LogAop {

    private Date visitTime; //访问时间
    private Class clazz; //访问类
    private Method method; //访问方法

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    /**
     * 前置通知
     * 获取开始时间 / 执行类 / 执行方法
     *
     * @param jp
     */
    @Before("execution(* com.zhaolei.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        clazz = jp.getTarget().getClass();
        if (!clazz.getName().contains("Log")) {
            visitTime = new Date();
            String methodName = jp.getSignature().getName(); //获取方法名
            Object[] args = jp.getArgs();

            //获取具体执行方法的Method对象
            if (args == null || args.length == 0) {
                method = clazz.getMethod(methodName);
            } else {
                Class[] classArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    classArgs[i] = args[i].getClass();
                }
                method = clazz.getMethod(methodName, classArgs);
            }
        }
    }

    /**
     * 后置通知
     *
     * @param jp
     */
    @After("execution(* com.zhaolei.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        if (!clazz.getName().contains("Log")) {
            long time = System.currentTimeMillis() - visitTime.getTime();

            //获取url
            String url = "";
            if (clazz != null && method != null && clazz != LogAop.class) {
                RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                if (classAnnotation != null) {
                    String[] classValue = classAnnotation.value();
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    if (methodAnnotation != null) {
                        String[] methodValue = methodAnnotation.value();
                        url = classValue[0] + methodValue[0];
                    }
                }
            }

            //获取ip
            String ip = request.getRemoteAddr();

            //获取当前操作的用户
            SecurityContext context = SecurityContextHolder.getContext();
            // 也可通过request中的session获取：
            // User user = (User) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
            User user = (User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();

            //将日志信息封装到SysLog对象中
            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time); //执行时长
            sysLog.setIp(ip);
            sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
            sysLog.setUrl(url);
            sysLog.setUsername(username);
            sysLog.setVisitTime(visitTime);
            sysLogService.save(sysLog);
        }
    }
}


