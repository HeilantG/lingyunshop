package com.lingyun.service.impl;

import com.lingyun.dao.TbSellerDao;
import com.lingyun.dao.TbUserDao;
import com.lingyun.entity.TbSeller;
import com.lingyun.entity.TbUser;
import com.lingyun.entity.util.MyUserDetails;
import com.lingyun.service.LoginShangJiaService;
import com.lingyun.service.LoginUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

@DubboService
public class LoginShangJiaServiceImpl implements LoginShangJiaService {

    @Resource
    TbSellerDao tbSellerDao;

    @Override
    public UserDetails loadUserByUsername(String id) {
        TbSeller tbUser = tbSellerDao.queryById(id);
        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUsername(tbUser.getName());
        myUserDetails.setPassword(tbUser.getPassword());
        return myUserDetails;
    }
}
