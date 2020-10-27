package com.lingyun.service;

import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.entity.util.PageResult;

import java.util.List;

/**
 * (TbTypeTemplate)表服务接口
 *
 * @author makejava
 * @since 2020-10-22 22:56:37
 */
public interface TbTypeTemplateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbTypeTemplate queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbTypeTemplate> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    int insert(TbTypeTemplate tbTypeTemplate);

    /**
     * 修改数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    TbTypeTemplate update(TbTypeTemplate tbTypeTemplate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    PageResult<TbTypeTemplate> findPage(Integer page, Integer rows);

    int deleteList(Long[] ids);
}