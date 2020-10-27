package com.lingyun.service;

import com.lingyun.entity.util.PageResult;
import com.lingyun.entity.TbSpecification;

import java.util.List;

/**
 * (TbSpecification)表服务接口
 *
 * @author makejava
 * @since 2020-10-22 10:31:54
 */
public interface TbSpecificationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbSpecification queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbSpecification> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    TbSpecification insert(TbSpecification tbSpecification);

    /**
     * 修改数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    TbSpecification update(TbSpecification tbSpecification);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 分页查询
     *
     * @param page 页码
     * @param rows 页面数据量
     * @return 对象集合
     */
    PageResult<TbSpecification> findPage(int page, int rows);

    /**
     * 模糊查询
     *
     * @param name 模糊数据
     * @return 结果集合
     */
    List<TbSpecification> blurrySelect(String name);

    List<TbSpecification> queryALl(TbSpecification tbSpecification);
}