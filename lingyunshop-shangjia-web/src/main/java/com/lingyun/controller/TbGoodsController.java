package com.lingyun.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lingyun.entity.TbGoods;
import com.lingyun.entity.TbGoodsDesc;
import com.lingyun.entity.TbItem;
import com.lingyun.entity.util.Goods;
import com.lingyun.entity.util.Result;
import com.lingyun.service.TbGoodsService;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * (TbGoods)表控制层
 *
 * @author makejava
 * @since 2020-10-28 17:07:25
 */
@Log4j2
@RestController
@RequestMapping("/tbGoods")
public class TbGoodsController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbGoodsService tbGoodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbGoods selectOne(Long id) {
        return this.tbGoodsService.queryById(id);
    }

    /**
     * 增加s
     */
    @PostMapping("/add")
    public Result add(@RequestBody JSONObject entity) {


        Goods goods = processJsonRequest(entity);
        //获取登录名
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        goods.getGoods().setSellerId(sellerId);//设置商家ID
        try {
            tbGoodsService.add(goods);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("增加失败");
        }
    }

    /**
     * 分页
     *
     * @param page 页码
     * @param rows 行数
     * @return 实体
     */
    @GetMapping("/search")
    public Result search(int page, int rows) {
        //获取商家ID
        //添加查询条件
        TbGoods goods = new TbGoods().setSellerId(SecurityContextHolder.getContext().getAuthentication().getName());
        return Result.success(tbGoodsService.findPage(goods, page, rows));
    }

    /**
     * 获取实体
     * @param id 父类id
     * @return
     */
    @GetMapping("/findOne")
    public Result findOne(Long id){
        return Result.success(tbGoodsService.findOne(id));
    }



    /**
     * 处理添加时的复杂实体类
     *
     * @param json Json字符串
     * @return 处理结果
     */
    private Goods processJsonRequest(JSONObject json) {
        Goods goods = new Goods();
        //取出TbGoodsJson
        JSONObject goodsJson = json.getJSONObject("goods");
        TbGoods tbGoods = new TbGoods()
                .setCategory1Id(goodsJson.getLong("category1Id"))
                .setCategory2Id(goodsJson.getLong("category3Id"))
                .setCategory3Id(goodsJson.getLong("category3Id"))
                .setTypeTemplateId(goodsJson.getLong("typeTemplateId"))
                .setGoodsName(goodsJson.getString("goodsName"))
                .setBrandId(goodsJson.getLong("brandId"))
                .setCaption(goodsJson.getString("caption"))
                .setPrice(goodsJson.getDouble("price"));
        goods.setGoods(tbGoods);


        //取出TbGoodsDescJSON
        JSONObject goodsDescJSON = json.getJSONObject("goodsDesc");
        TbGoodsDesc tbGoodsDesc = new TbGoodsDesc()
                .setItemImages(goodsDescJSON.getString("itemImages"))
                .setSpecificationItems(goodsDescJSON.getString("specificationItems"))
                .setIntroduction(goodsDescJSON.getString("introduction"))
                .setCustomAttributeItems(goodsDescJSON.getString("customAttributeItems"))
                .setPackageList(goodsDescJSON.getString("packageList"))
                .setSaleService(goodsDescJSON.getString("saleService"));
        goods.setGoodsDesc(tbGoodsDesc);


        JSONArray itemList = json.getJSONArray("itemList");
        ArrayList<TbItem> tbItems = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            JSONObject jsonObject = itemList.getJSONObject(i);
            tbItems.add(new TbItem().setSpec(jsonObject.getString("spec"))
                    .setPrice(jsonObject.getDouble("price"))
                    .setNum(jsonObject.getInteger("num"))
                    .setStatus(jsonObject.getString("status"))
                    .setIsDefault(jsonObject.getString("isDefault"))
                    .setTitle("默认标题")
                    .setCategoryid(tbGoods.getCategory3Id())
                    .setStatus("1")
                    .setCreateTime(new Date())
                    .setUpdateTime(new Date()))
            ;
        }
        System.out.println("Json->>>>>" + tbItems.toString());
        goods.setItemList(tbItems);
        return goods;
    }
}