package com.lingyun.service;

import com.lingyun.entity.TbSeller;

import java.util.List;

/**
 * (TbSeller)表服务接口
 *
 * @author makejava
 * @since 2020-10-27 15:19:59
 */
public interface TbSellerService {

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    TbSeller queryById(String sellerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbSeller> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    TbSeller insert(TbSeller tbSeller);

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    TbSeller update(TbSeller tbSeller);

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 是否成功
     */
    boolean deleteById(String sellerId);

}