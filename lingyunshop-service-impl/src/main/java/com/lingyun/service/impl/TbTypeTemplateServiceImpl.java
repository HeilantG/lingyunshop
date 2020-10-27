package com.lingyun.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lingyun.dao.TbBrandDao;
import com.lingyun.dao.TbSpecificationDao;
import com.lingyun.dao.TbTypeTemplateDao;
import com.lingyun.entity.TbSpecification;
import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.entity.util.PageResult;
import com.lingyun.service.TbTypeTemplateService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbTypeTemplate)表服务实现类
 *
 * @author makejava
 * @since 2020-10-22 22:56:43
 */
@DubboService
public class TbTypeTemplateServiceImpl implements TbTypeTemplateService {
    @Resource
    private TbTypeTemplateDao tbTypeTemplateDao;

    @Resource
    private TbSpecificationDao tbSpecificationDao;

    @Resource
    private TbBrandDao tbBrandDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbTypeTemplate queryById(Long id) {
        return this.tbTypeTemplateDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbTypeTemplate> queryAllByLimit(int offset, int limit) {
        return this.tbTypeTemplateDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(TbTypeTemplate tbTypeTemplate) {

        //转换规格id为JSON格式
        JSONArray specJsonArray = new JSONArray();
        List<TbSpecification> tbSpecifications = tbSpecificationDao.queryIds(tbTypeTemplate.getSpecIds().split(","));
        tbSpecificationDao.queryIds(tbTypeTemplate.getSpecIds().split(",")).forEach(tbSpecification -> {
            JSONObject specJson = new JSONObject();
            specJson.put("id", tbSpecification.getId());
            specJson.put("text", tbSpecification.getSpecName());
            specJsonArray.add(specJson);
        });
        tbTypeTemplate.setSpecIds(specJsonArray.toString());
        //转换品牌id为JSON格式
        JSONArray tbBrandArray = new JSONArray();
        tbBrandDao.queryIds(tbTypeTemplate.getBrandIds().split(",")).forEach(tbBrand -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", tbBrand.getId());
            jsonObject.put("text", tbBrand.getName());
            tbBrandArray.add(tbBrand);
        });
        tbTypeTemplate.setBrandIds(specJsonArray.toString());
        System.out.println(tbTypeTemplate.toString());
        return this.tbTypeTemplateDao.insert(tbTypeTemplate);
    }


    /**
     * 修改数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public TbTypeTemplate update(TbTypeTemplate tbTypeTemplate) {
        this.tbTypeTemplateDao.update(tbTypeTemplate);
        return this.queryById(tbTypeTemplate.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbTypeTemplateDao.deleteById(id) > 0;
    }

    @Override
    public PageResult<TbTypeTemplate> findPage(Integer page, Integer rows) {
        int size = this.tbTypeTemplateDao.queryAll(new TbTypeTemplate()).size();
        List<TbTypeTemplate> tbTypeTemplates = this.tbTypeTemplateDao.queryAllByLimit(--page * rows, rows);
        return new PageResult<>(size, tbTypeTemplates);
    }

    @Override
    public int deleteList(Long[] ids) {
        return this.tbTypeTemplateDao.deleteList(ids);
    }
}