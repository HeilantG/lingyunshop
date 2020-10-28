package com.lingyun.controller;

import com.lingyun.entity.TbItemCat;
import com.lingyun.entity.util.Result;
import com.lingyun.service.TbItemCatService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 商品类目(TbItemCat)表控制层
 *
 * @author makejava
 * @since 2020-10-28 14:36:34
 */
@Log4j2
@RestController
@RequestMapping("/tbItemCat")
public class TbItemCatController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbItemCatService tbItemCatService;


    /**
     * 根据上级ID查询列表
     *
     * @param parentId 上级id
     * @return 所有满足条件的数据
     */
    @GetMapping("/findByParentId")
    public Result findByParentId(Long parentId) {
        return Result.success(this.tbItemCatService.findByParentId(parentId));
    }

    /**
     * 保存
     *
     * @param tbItemCat 实体
     * @return 是否成功
     */
    @PostMapping("/save")
    public Result save(@RequestBody TbItemCat tbItemCat) {
        return Result.success(this.tbItemCatService.insert(tbItemCat));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Result selectOne(long id) {
        return Result.success(this.tbItemCatService.queryById(id));
    }

    /**
     * 通过主键修改单条数据
     *
     * @param tbItemCat 对象实体
     * @return 是否修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody TbItemCat tbItemCat) {
        return Result.success(this.tbItemCatService.update(tbItemCat));
    }

    @PostMapping("/deleteList")
    public Result deleteList(@RequestBody Long[] ids) {
        return Result.success(this.tbItemCatService.deleteList(ids));
    }


}