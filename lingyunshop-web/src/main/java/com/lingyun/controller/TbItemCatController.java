package com.lingyun.controller;

import com.lingyun.entity.TbItemCat;
import com.lingyun.service.TbItemCatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品类目(TbItemCat)表控制层
 *
 * @author makejava
 * @since 2020-10-28 14:36:34
 */
@RestController
@RequestMapping("tbItemCat")
public class TbItemCatController {
    /**
     * 服务对象
     */
    @Resource
    private TbItemCatService tbItemCatService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbItemCat selectOne(Long id) {
        return this.tbItemCatService.queryById(id);
    }

}