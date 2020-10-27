package com.lingyun.service.impl;

import com.lingyun.dao.TbSpecificationDao;
import com.lingyun.entity.util.PageResult;
import com.lingyun.entity.TbSpecification;
import com.lingyun.service.TbSpecificationService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbSpecification)表服务实现类
 *
 * @author makejava
 * @since 2020-10-22 10:32:00
 */
@DubboService
public class TbSpecificationServiceImpl implements TbSpecificationService {
    @Resource
    private TbSpecificationDao tbSpecificationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbSpecification queryById(Long id) {
        return this.tbSpecificationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbSpecification> queryAllByLimit(int offset, int limit) {
        return this.tbSpecificationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    @Override
    public TbSpecification insert(TbSpecification tbSpecification) {
        this.tbSpecificationDao.insert(tbSpecification);
        return tbSpecification;
    }

    /**
     * 修改数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    @Override
    public TbSpecification update(TbSpecification tbSpecification) {
        this.tbSpecificationDao.update(tbSpecification);
        return this.queryById(tbSpecification.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbSpecificationDao.deleteById(id) > 0;
    }

    @Override
    public PageResult<TbSpecification> findPage(int page, int rows) {
        int size = this.tbSpecificationDao.queryAll(new TbSpecification()).size();
        List<TbSpecification> tbSpecifications = this.tbSpecificationDao.queryAllByLimit(--page * rows, rows);
        return new PageResult<>(size, tbSpecifications);
    }

    @Override
    public List<TbSpecification> blurrySelect(String name) {
        return this.tbSpecificationDao.blurrySelect(name);
    }

    @Override
    public List<TbSpecification> queryALl(TbSpecification tbSpecification) {
        return this.tbSpecificationDao.queryAll(tbSpecification);
    }
}