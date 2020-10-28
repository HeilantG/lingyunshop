package com.lingyun.service.impl;

import com.lingyun.dao.TbItemCatDao;
import com.lingyun.entity.TbItemCat;
import com.lingyun.service.TbItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类目(TbItemCat)表服务实现类
 *
 * @author makejava
 * @since 2020-10-28 14:36:26
 */
@Service("tbItemCatService")
public class TbItemCatServiceImpl implements TbItemCatService {
    @Resource
    private TbItemCatDao tbItemCatDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbItemCat queryById(Long id) {
        return this.tbItemCatDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbItemCat> queryAllByLimit(int offset, int limit) {
        return this.tbItemCatDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    @Override
    public TbItemCat insert(TbItemCat tbItemCat) {
        this.tbItemCatDao.insert(tbItemCat);
        return tbItemCat;
    }

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    @Override
    public TbItemCat update(TbItemCat tbItemCat) {
        this.tbItemCatDao.update(tbItemCat);
        return this.queryById(tbItemCat.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbItemCatDao.deleteById(id) > 0;
    }
}