package com.lingyun.service.impl;

import com.lingyun.dao.TbBrandDao;
import com.lingyun.entity.util.PageResult;
import com.lingyun.entity.TbBrand;
import com.lingyun.service.TbBrandService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbBrand)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 23:23:53
 */
@DubboService
public class TbBrandServiceImpl implements TbBrandService {
    @Resource
    private TbBrandDao tbBrandDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbBrand queryById(Long id) {
        return this.tbBrandDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbBrand> queryAllByLimit(int offset, int limit) {
        return this.tbBrandDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    public TbBrand insert(TbBrand tbBrand) {
        this.tbBrandDao.insert(tbBrand);
        return tbBrand;
    }

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    public TbBrand update(TbBrand tbBrand) {
        this.tbBrandDao.update(tbBrand);
        return this.queryById(tbBrand.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbBrandDao.deleteById(id) > 0;
    }

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 页面数据
     */
    @Override
    public PageResult<TbBrand> findPage(int pageNum, int pageSize) {
        int size = this.tbBrandDao.queryAll(new TbBrand()).size();
        List<TbBrand> tbBrands = this.tbBrandDao.queryAllByLimit(--pageNum * pageSize, pageSize);
        return new PageResult<>(size, tbBrands);
    }

    /**
     * 模糊查询
     *
     * @param name 查询条件
     * @return 查询列表
     */
    @Override
    public List<TbBrand> blurrySelect(String name) {
        return this.tbBrandDao.blurrySelect(name);
    }

    @Override
    public List<TbBrand> queryAll(TbBrand tbBrand) {
        return this.tbBrandDao.queryAll(tbBrand);
    }
}