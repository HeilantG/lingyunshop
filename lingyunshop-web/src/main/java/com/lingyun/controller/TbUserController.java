package com.lingyun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lingyun.entity.TbUser;
import com.lingyun.entity.util.Result;
import com.lingyun.service.TbUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户表(TbUser)表控制层
 *
 * @author makejava
 * @since 2020-10-27 14:48:45
 */
@RestController
@RequestMapping("/tbUser")
public class TbUserController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbUserService tbUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbUser selectOne(Long id) {
        return this.tbUserService.queryById(id);
    }

    @GetMapping("/name")
    public Result name(String username) {
        String name = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loginName", name);
        return Result.success(jsonObject);


    }
}