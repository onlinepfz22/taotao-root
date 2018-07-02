package com.bsoft.root.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bsoft.root.entity.PoRoleAuthority;
import com.bsoft.root.entity.PoRoleAuthorityExample;
import com.bsoft.root.entity.PoUser;
import com.bsoft.root.mappers.PoRoleAuthorityMapper;
import com.bsoft.root.mappers.PoUserMapper;
import com.bsoft.root.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YSFY
 * @Date: 2018/6/21 16:43
 * @Pacage_name: com.bsoft.root.service.impl
 * @Project_Name: taotao-root
 * @Description:    用户实现类
 */

@Component(value = "userService")
@Service(version="1.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private PoUserMapper poUserMapper;

    @Autowired
    private PoRoleAuthorityMapper poRoleAuthorityMapper;

    @Override
    public PoUser getUser(Integer id) {
        PoUser poUser = this.poUserMapper.selectByPrimaryKey(id);
        return poUser;
    }

    @Override
    public boolean addUser(PoUser poUser) {
        return poUserMapper.insert(poUser)>0?true:false ;
    }

    @Override
    public void batchUpdate() {
        PoRoleAuthorityExample poRoleAuthorityExample = new PoRoleAuthorityExample();
        poRoleAuthorityExample.createCriteria().andRoleIdEqualTo(new Integer(2));

        List<PoRoleAuthority> list = this.poRoleAuthorityMapper.selectByExample(poRoleAuthorityExample);
        System.out.println("the sum authority menu count for return is: " + list.size());

        if(null != list && list.size()>0) {

            //开始批量更新
            List<Integer> authorityList = new ArrayList<Integer>();
            for(PoRoleAuthority poRoleAuthority : list) {
                authorityList.add(Integer.valueOf(poRoleAuthority.getAuthorityId()));
            }

            int result = this.poRoleAuthorityMapper.batchUpdate(new Integer(2), authorityList);
            System.out.println("after update influence count is ：" + result);
        }
    }

}
