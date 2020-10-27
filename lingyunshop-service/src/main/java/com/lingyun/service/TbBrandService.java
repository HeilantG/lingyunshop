package com.lingyun.service;

import com.lingyun.entity.util.PageResult;
import com.lingyun.entity.TbBrand;

import java.util.List;

/**
 * (TbBrand)表服务接口
 *
 * @author makejava
 * @since 2020-10-20 23:23:48
 */
public interface TbBrandService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBrand queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbBrand> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    TbBrand insert(TbBrand tbBrand);

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    TbBrand update(TbBrand tbBrand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 页面list
     */
    PageResult<TbBrand> findPage(int pageNum, int pageSize);

    /**
     * 模糊查询
     * @param name 查询条件
     * @return 查询列表
     */
    List<TbBrand> blurrySelect(String name);

    List<TbBrand> queryAll(TbBrand tbBrand);
}