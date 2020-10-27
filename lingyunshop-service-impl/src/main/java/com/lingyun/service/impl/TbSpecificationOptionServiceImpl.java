package com.lingyun.service.impl;

import com.lingyun.dao.TbSpecificationOptionDao;
import com.lingyun.entity.TbSpecificationOption;
import com.lingyun.service.TbSpecificationOptionService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbSpecificationOption)表服务实现类
 *
 * @author makejava
 * @since 2020-10-22 18:44:35
 */
@DubboService
public class TbSpecificationOptionServiceImpl implements TbSpecificationOptionService {
    @Resource
    private TbSpecificationOptionDao tbSpecificationOptionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbSpecificationOption queryById(Long id) {
        return this.tbSpecificationOptionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbSpecificationOption> queryAllByLimit(int offset, int limit) {
        return this.tbSpecificationOptionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    @Override
    public TbSpecificationOption insert(TbSpecificationOption tbSpecificationOption) {
        this.tbSpecificationOptionDao.insert(tbSpecificationOption);
        return tbSpecificationOption;
    }

    /**
     * 修改数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    @Override
    public TbSpecificationOption update(TbSpecificationOption tbSpecificationOption) {
        this.tbSpecificationOptionDao.update(tbSpecificationOption);
        return this.queryById(tbSpecificationOption.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbSpecificationOptionDao.deleteById(id) > 0;
    }

    @Override
    public List<TbSpecificationOption> queryBySpecId(Long specId) {
        return this.tbSpecificationOptionDao.queryBySpecId(specId);
    }

    @Override
    public boolean deleteBySpecId(Long specId) {
        return this.tbSpecificationOptionDao.deleteBySpecId(specId);
    }


}