package com.lingyun.service;

import com.lingyun.entity.TbItemCat;

import java.util.List;

/**
 * 商品类目(TbItemCat)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 14:36:19
 */
public interface TbItemCatService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbItemCat queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbItemCat> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    TbItemCat insert(TbItemCat tbItemCat);

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    TbItemCat update(TbItemCat tbItemCat);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据上级id返回列表
     *
     * @param parentId 上级列表
     * @return 实例列表
     */
    public List<TbItemCat> findByParentId(Long parentId);

    public int deleteList(Long[] ids);

}