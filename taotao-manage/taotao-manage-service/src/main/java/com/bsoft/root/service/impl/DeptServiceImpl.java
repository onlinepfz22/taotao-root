package com.bsoft.root.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bsoft.root.entity.PoDept;
import com.bsoft.root.mappers.PoDeptMapper;
import com.bsoft.root.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: YSFY
 * @Date: 2018/6/25 08:19
 * @Pacage_name: com.bsoft.root.service.impl
 * @Project_Name: taotao-root
 * @Description:    部门实现类
 */

@Component(value = "deptService")
@Service(version="1.0")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private PoDeptMapper poDeptMapper;

    @Override
    public PoDept getDept(Integer id) {
        return this.poDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean addDept(PoDept poDept) {
        return this.poDeptMapper.insert(poDept)>0?true:false;
    }

}
