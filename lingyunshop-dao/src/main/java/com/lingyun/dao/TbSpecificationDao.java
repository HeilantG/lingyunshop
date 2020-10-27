package com.lingyun.dao;

import com.lingyun.entity.TbSpecification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbSpecification)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 10:29:24
 */
@Mapper
public interface TbSpecificationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbSpecification queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbSpecification> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbSpecification 实例对象
     * @return 对象列表
     */
    List<TbSpecification> queryAll(TbSpecification tbSpecification);

    /**
     * 新增数据
     *
     * @param tbSpecification 实例对象
     * @return 影响行数
     */
    int insert(TbSpecification tbSpecification);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSpecification> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbSpecification> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSpecification> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbSpecification> entities);

    /**
     * 修改数据
     *
     * @param tbSpecification 实例对象
     * @return 影响行数
     */
    int update(TbSpecification tbSpecification);

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
     * @param name 模糊数据
     * @return 结果集合
     */
    List<TbSpecification> blurrySelect(String name);

    /**
     * 通过id数组查询
     *
     * @param ids id数组
     * @return 结果集合
     */
    List<TbSpecification> queryIds(String[] ids);
}