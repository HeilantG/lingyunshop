package com.lingyun.service.impl;

import com.lingyun.dao.TbSellerDao;
import com.lingyun.entity.TbSeller;
import com.lingyun.service.TbSellerService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TbSeller)表服务实现类
 *
 * @author makejava
 * @since 2020-10-27 15:20:05
 */
@DubboService
public class TbSellerServiceImpl implements TbSellerService {
    @Resource
    private TbSellerDao tbSellerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    @Override
    public TbSeller queryById(String sellerId) {
        return this.tbSellerDao.queryById(sellerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbSeller> queryAllByLimit(int offset, int limit) {
        return this.tbSellerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    @Override
    public TbSeller insert(TbSeller tbSeller) {
        tbSeller.setStatus("0");
        tbSeller.setCreateTime(new Date());
        this.tbSellerDao.insert(tbSeller);
        return tbSeller;
    }

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    @Override
    public TbSeller update(TbSeller tbSeller) {
        this.tbSellerDao.update(tbSeller);
        return this.queryById(tbSeller.getSellerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String sellerId) {
        return this.tbSellerDao.deleteById(sellerId) > 0;
    }
}