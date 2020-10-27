package com.lingyun.service.impl;

import com.lingyun.dao.TbUserDao;
import com.lingyun.entity.TbUser;
import com.lingyun.entity.util.MyUserDetails;
import com.lingyun.service.LoginUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

@DubboService
public class LoginUserServiceImpl implements LoginUserService {

    @Resource
    TbUserDao tbUserDao;

    @Override
    public UserDetails loadUserByUsername(String id) {
        TbUser tbUser = tbUserDao.queryById(Long.parseLong(id));
        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUsername(tbUser.getUsername());
        myUserDetails.setPassword(tbUser.getPassword());
        return myUserDetails;
    }
}
