package com.lingyun.controller;

import com.lingyun.entity.TbContent;
import com.lingyun.service.TbContentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TbContent)表控制层
 *
 * @author makejava
 * @since 2020-11-03 15:42:43
 */
@RestController
@RequestMapping("tbContent")
public class TbContentController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbContentService tbContentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbContent selectOne(Long id) {
        return this.tbContentService.queryById(id);
    }

}