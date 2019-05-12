package com.zhaolei.controller;


import com.zhaolei.domain.UserInfo;
import com.zhaolei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * SSM
 * 2019-05-10 00:58
 *
 * @author leonzhao
 **/

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserAndRoleById.do")
    public ModelAndView findUserAndRoleById(@RequestParam(name="id") String userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findRolesByUserId(userid);
        mv.addObject("user", userInfo);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam("userId") String userId, @RequestParam("ids") String[] roleIds) throws Exception {

        userService.addRoleToUser(userId, roleIds);

        return "redirect:findAll.do";
    }


}
