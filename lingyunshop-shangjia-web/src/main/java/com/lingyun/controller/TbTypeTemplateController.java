package com.lingyun.controller;

import com.alibaba.fastjson.JSON;
import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.entity.util.Result;
import com.lingyun.service.TbTypeTemplateService;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * (TbTypeTemplate)表控制层
 *
 * @author makejava
 * @since 2020-10-22 22:56:51
 */
@Log4j2
@RestController
@RequestMapping("/tbTypeTemplate")
public class TbTypeTemplateController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbTypeTemplateService tbTypeTemplateService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Result selectOne(Long id) {
        return Result.success(this.tbTypeTemplateService.queryById(id));
    }

    /**
     * 分页
     *
     * @param page 请求页码
     * @param rows 请求行数
     * @return 当页数据
     */
    @GetMapping("/findPage")
    public Result findPage(Integer page, Integer rows) {
        return Result.success(tbTypeTemplateService.findPage(page, rows));
    }

    @PostMapping("/save")
    public Result save(@RequestBody TbTypeTemplate tbTypeTemplate) {
        tbTypeTemplateService.insert(tbTypeTemplate);
        return Result.success();
    }

    @PostMapping("/deleteList")
    public Result deleteList(@RequestBody Long[] ids) {
        return Result.success(tbTypeTemplateService.deleteList(ids));
    }

    @RequestMapping("/findSpecList")
    public Result findSpecList(Long id) {
        return Result.success(tbTypeTemplateService.findSpecList(id));
    }

}