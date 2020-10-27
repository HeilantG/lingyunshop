package com.lingyun.dao;

import com.lingyun.entity.TbBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbBrand)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-20 23:23:36
 */
@Mapper
public interface TbBrandDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBrand queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbBrand> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbBrand 实例对象
     * @return 对象列表
     */
    List<TbBrand> queryAll(TbBrand tbBrand);

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 影响行数
     */
    int insert(TbBrand tbBrand);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbBrand> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbBrand> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbBrand> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbBrand> entities);

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 影响行数
     */
    int update(TbBrand tbBrand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 模糊查询
     *
     * @param name 查询条件
     * @return 查询列表
     */
    List<TbBrand> blurrySelect(String name);

    /**
     * 通过id数组查询
     *
     * @param ids id数组
     * @return 查询列表
     */
    List<TbBrand> queryIds(String[] ids);
}