package com.lingyun.controller;

import com.lingyun.entity.util.Result;
import com.lingyun.entity.TbSpecification;
import com.lingyun.entity.util.Specification;
import com.lingyun.service.TbSpecificationOptionService;
import com.lingyun.service.TbSpecificationService;
import com.lingyun.entity.TbSpecificationOption;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * (TbSpecification)表控制层
 *
 * @author makejava
 * @since 2020-10-22 10:32:08
 */
@Log4j2
@RestController
@RequestMapping("/tbSpecification")
public class TbSpecificationController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbSpecificationService tbSpecificationService;
    @DubboReference
    private TbSpecificationOptionService tbSpecificationOptionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Result selectOne(Long id) {
        return Result.success(this.tbSpecificationService.queryById(id));
    }

    /**
     * @param page 页码
     * @param rows 页面数据量
     * @return 对象集合
     */
    @GetMapping("/findPage")
    public Result findPage(Integer page, Integer rows) {
        return Result.success(this.tbSpecificationService.findPage(page, rows));
    }

    /**
     * @param specification 携带者规格和下属模板列表的实体类
     * @return 状态码
     */
    @PostMapping("/save")
    public Result save(@RequestBody Specification<TbSpecification, TbSpecificationOption> specification) {
        TbSpecification insert = tbSpecificationService.insert(specification.getEntity());
        List<TbSpecificationOption> specificationOptionList = specification.getEntityList();
        specificationOptionList.forEach(sp -> {
            tbSpecificationOptionService.insert(sp.setSpecId(insert.getId()));
        });
        return Result.success();
    }

    /**
     * 规格修改
     * 规格修改 同时 修改从表
     *
     * @param specification 携带规格和规格从表的实体集合
     * @return 状态码
     */
    @PostMapping("/update")
    public Result update(@RequestBody Specification<TbSpecification, TbSpecificationOption> specification) {
        if (tbSpecificationService.update(specification.getEntity()) != null) {
            specification.getEntityList().forEach(tbSpecificationOptionService::update);
            return Result.success();
        } else {
            return Result.error("UPDATE ERROR");
        }
    }

    /**
     * 批量删除
     * 批量删除 自身 与 从表
     *
     * @param ids 被删除的id数组
     * @return 状态码
     */
    @PostMapping("/deleteList")
    public Result deleteList(@RequestBody Long[] ids) {
        Arrays.stream(ids).forEach(id -> {
            tbSpecificationOptionService.deleteBySpecId(id);
            tbSpecificationService.deleteById(id);
        });
        return Result.success();
    }

    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    @GetMapping("/blurrySelect")
    public Result blurrySelect(String name) {
        return Result.success(this.tbSpecificationService.blurrySelect(name));
    }

    @GetMapping("/queryAll")
    public Result queryAll() {
        return Result.success(this.tbSpecificationService.queryALl(new TbSpecification()));
    }

}