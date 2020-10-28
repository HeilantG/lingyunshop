package com.lingyun.dao;

import com.lingyun.entity.TbSeller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbSeller)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-27 15:19:53
 */
@Mapper
public interface TbSellerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    TbSeller queryById(String sellerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbSeller> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbSeller 实例对象
     * @return 对象列表
     */
    List<TbSeller> queryAll(TbSeller tbSeller);

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 影响行数
     */
    int insert(TbSeller tbSeller);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSeller> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbSeller> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSeller> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbSeller> entities);

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 影响行数
     */
    int update(TbSeller tbSeller);

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 影响行数
     */
    int deleteById(String sellerId);

}