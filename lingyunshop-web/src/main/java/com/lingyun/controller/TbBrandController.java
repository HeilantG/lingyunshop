package com.lingyun.controller;

import com.lingyun.entity.util.Result;
import com.lingyun.entity.TbBrand;
import com.lingyun.service.TbBrandService;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 品牌
 * (TbBrand)表控制层
 *
 * @author makejava
 * @since 2020-10-20 23:24:01
 */
@Log4j2
@RestController
@RequestMapping("/tbBrand")
public class TbBrandController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbBrandService tbBrandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Result selectOne(Long id) {
        return Result.success(this.tbBrandService.queryById(id));
    }


    @GetMapping("/findPage")
    public Result findPage(Integer page, Integer rows) {
        return Result.success(this.tbBrandService.findPage(page, rows));
    }

    /**
     * @param tbBrand 厂家对象
     * @return 是否添加成功
     */
    @PostMapping("/saveBand")
    public boolean saveBand(@RequestBody TbBrand tbBrand) {
        log.info(tbBrand.toString());
        TbBrand insert = this.tbBrandService.insert(tbBrand);
        return insert != null;

    }

    /**
     * 批量删除
     *
     * @param ids id号
     * @return 状态
     */
    @PostMapping("/deleteList")
    public Result deleteList(@RequestBody Long[] ids) {
        Arrays.stream(ids).forEach(id -> this.tbBrandService.deleteById(id));
        return Result.success();
    }


    @PostMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        if (this.tbBrandService.update(tbBrand) != null)
            return Result.success();
        else
            return Result.error("修改错误");
    }

    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    @GetMapping("/blurrySelect")
    public Result blurrySelect(String name) {
        return Result.success(this.tbBrandService.blurrySelect(name));
    }

    /**
     * 查询所有
     *
     * @return 品牌列表
     */
    @GetMapping("/queryAll")
    public Result queryAll() {
        return Result.success(this.tbBrandService.queryAll(new TbBrand()));
    }

}