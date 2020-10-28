package com.lingyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingyun.entity.TbSeller;
import com.lingyun.entity.util.Result;
import com.lingyun.service.TbSellerService;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * (TbSeller)表控制层
 *
 * @author makejava
 * @since 2020-10-27 15:20:11
 */
@Log4j2
@RestController
@RequestMapping("/tbSeller")
public class TbSellerController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbSellerService tbSellerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbSeller selectOne(String id) {
        return this.tbSellerService.queryById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TbSeller tbSeller) {
        //密码加密
/*
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(tbSeller.getPassword());//加密
        tbSeller.setPassword(password);
*/
        log.warn(tbSeller.toString());
        try {
            tbSellerService.insert(tbSeller);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("增加失败");
        }

    }

    @GetMapping("/name")
    public Result name() {
        String name = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loginName", name);
        return Result.success(jsonObject);
    }

}