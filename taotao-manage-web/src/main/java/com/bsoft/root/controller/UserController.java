package com.bsoft.root.controller;

import com.bsoft.root.entity.PoUser;
import com.bsoft.root.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: YSFY
 * @Date: 2018/6/21 17:43
 * @Pacage_name: com.bsoft.root.controller
 * @Project_Name: taotao-root
 * @Description:    用户控制器
 */

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user")
    @ResponseBody
    public PoUser getUser() {

        PoUser poUser = this.userService.getUser(new Integer(1));
        return poUser;
    }

    @RequestMapping(value="/addUser")
    @ResponseBody
    public String addUser() {

        PoUser poUser = new PoUser();
        poUser.setDeptId(5);
        poUser.setUserName("dubbo");
        poUser.setPassword("dubbo");
        poUser.setRealName("dubbo分布式");
        poUser.setRoleId(5);
        poUser.setLastTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        poUser.setStatus(new Integer(1));

        return userService.addUser(poUser)==true?"插入成功":"插入失败";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void batchUpdate() {
        this.userService.batchUpdate();
    }

}
