package com.bsoft.root.service;

import com.bsoft.root.entity.PoDept;

/**
 * @Auther: YSFY
 * @Date: 2018/6/25 08:19
 * @Pacage_name: com.bsoft.root.service
 * @Project_Name: taotao-root
 * @Description:    部门接口
 */
public interface DeptService {

    PoDept getDept(Integer id);

    boolean addDept(PoDept poDept);

}
