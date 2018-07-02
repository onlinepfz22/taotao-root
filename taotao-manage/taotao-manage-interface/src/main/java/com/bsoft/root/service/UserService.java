package com.bsoft.root.service;

import com.bsoft.root.entity.PoUser;

/**
 * @Auther: YSFY
 * @Date: 2018/6/21 16:41
 * @Pacage_name: com.bsoft.root.service
 * @Project_Name: taotao-root
 * @Description:   用户接口
 */
public interface UserService {

    PoUser getUser(Integer id);

    boolean addUser(PoUser poUser);

    void batchUpdate();
}
