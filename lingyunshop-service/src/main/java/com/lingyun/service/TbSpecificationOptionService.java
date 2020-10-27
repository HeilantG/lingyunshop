package com.lingyun.service;

import com.lingyun.entity.TbSpecificationOption;

import java.util.List;

/**
 * (TbSpecificationOption)表服务接口
 *
 * @author makejava
 * @since 2020-10-22 18:44:21
 */
public interface TbSpecificationOptionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbSpecificationOption queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbSpecificationOption> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    TbSpecificationOption insert(TbSpecificationOption tbSpecificationOption);

    /**
     * 修改数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    TbSpecificationOption update(TbSpecificationOption tbSpecificationOption);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过父id查询
     *
     * @param specId id
     * @return 根据父亲id查处的
     */
    List<TbSpecificationOption> queryBySpecId(Long specId);

    /**
     * 通过父id 删除
     *
     * @param specId 父亲id
     * @return 是否删除
     */
    boolean deleteBySpecId(Long specId);

}