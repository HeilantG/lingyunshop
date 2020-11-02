package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbGoodsDesc)实体类
 *
 * @author makejava
 * @since 2020-10-28 16:55:01
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class TbGoodsDesc implements Serializable {
    private static final long serialVersionUID = -75537308098169641L;
    /**
     * SPU_ID
     */
    private Long goodsId;
    /**
     * 描述
     */
    private String introduction;
    /**
     * 规格结果集，所有规格，包含isSelected
     */
    private String specificationItems;
    /**
     * 自定义属性（参数结果）
     */
    private String customAttributeItems;

    private String itemImages;
    /**
     * 包装列表
     */
    private String packageList;
    /**
     * 售后服务
     */
    private String saleService;

}