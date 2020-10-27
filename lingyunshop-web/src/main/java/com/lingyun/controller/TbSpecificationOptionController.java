package com.lingyun.controller;

import com.lingyun.entity.util.Result;
import com.lingyun.entity.TbSpecificationOption;
import com.lingyun.service.TbSpecificationOptionService;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (TbSpecificationOption)表控制层
 *
 * @author makejava
 * @since 2020-10-22 18:44:41
 */
@Log4j2
@RestController
@RequestMapping("/tbSpecificationOption")
public class TbSpecificationOptionController {
    /**
     * 服务对象
     */
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
        return Result.success(this.tbSpecificationOptionService.queryById(id));
    }

    /**
     * 通过父id查询
     *
     * @param specId id
     * @return 根据父亲id查处的
     */
    @GetMapping("/queryBySpecId")
    public Result queryBySpecId(Long specId) {
        return Result.success(this.tbSpecificationOptionService.queryBySpecId(specId));
    }

    /**
     * @param entity 携带者父类和被修改列表的实体
     * @return 状态码
     */
    @PostMapping("/update")
    public Result update(List<TbSpecificationOption> entity) {
        log.info(entity.toString());
        return Result.success();
    }
}