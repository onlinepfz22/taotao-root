package com.bsoft.root.controller;

import com.bsoft.root.entity.PoDept;
import com.bsoft.root.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: YSFY
 * @Date: 2018/6/25 08:21
 * @Pacage_name: com.bsoft.root.controller
 * @Project_Name: taotao-root
 * @Description:    部门控制器
 */

@Controller
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping(value="/dept")
    @ResponseBody
    public PoDept getDept() {
        return this.deptService.getDept(new Integer(1));
    }

    @RequestMapping(value="/addDept")
    @ResponseBody
    public String addDept() {

        PoDept poDept = new PoDept();
        poDept.setUpperId(1);
        poDept.setDeptName("人力资源部");
        poDept.setDeptAddress("杭州市上城区");
        poDept.setDeptCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        poDept.setDeptLinkman("悦诗风吟");
        poDept.setRemark("暂无");
        poDept.setStatus(1);

        return this.deptService.addDept(poDept)==true?"add dept success":"add dept fail";
    }

}
