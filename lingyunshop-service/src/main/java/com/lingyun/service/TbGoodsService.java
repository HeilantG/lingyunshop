package com.lingyun.service;

import com.lingyun.entity.TbGoods;
import com.lingyun.entity.util.Goods;
import com.lingyun.entity.util.PageResult;

import java.util.List;

/**
 * (TbGoods)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 16:59:59
 */
public interface TbGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbGoods queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbGoods> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    TbGoods insert(TbGoods tbGoods);

    /**
     * 修改数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    TbGoods update(TbGoods tbGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 增加
     */
    public void add(Goods goods);


    PageResult findPage(TbGoods goods, int page, int rows);
}