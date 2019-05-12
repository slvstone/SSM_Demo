package com.zhaolei.controller;

import com.zhaolei.domain.Role;
import com.zhaolei.service.PermissionService;
import com.zhaolei.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * SSM
 * 2019-05-10 14:19
 *
 * @author leonzhao
 **/

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList", roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleAndPermissionById.do")
    public ModelAndView findRoleAndPermissionById(@RequestParam("id") String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findRoleAndPermissionById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam("roleId") String roleId, @RequestParam("ids") String[] Permissions) throws Exception {
        roleService.addPermissionToRole(roleId, Permissions);
        return "redirect:findAll.do";
    }
}
