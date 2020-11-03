package com.lingyun.controller;

import com.lingyun.entity.TbContentCategory;
import com.lingyun.service.TbContentCategoryService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 内容分类(TbContentCategory)表控制层
 *
 * @author makejava
 * @since 2020-11-03 15:43:04
 */
@RestController
@RequestMapping("tbContentCategory")
public class TbContentCategoryController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbContentCategoryService tbContentCategoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbContentCategory selectOne(Long id) {
        return this.tbContentCategoryService.queryById(id);
    }

}