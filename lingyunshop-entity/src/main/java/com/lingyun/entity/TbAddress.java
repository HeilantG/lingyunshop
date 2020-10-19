package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbAddress)实体类
 *
 * @author makejava
 * @since 2020-10-19 00:06:08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TbAddress implements Serializable {
    private Long id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 省
     */
    private String provinceId;
    /**
     * 市
     */
    private String cityId;
    /**
     * 县/区
     */
    private String townId;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 是否是默认 1默认 0否
     */
    private String isDefault;
    /**
     * 备注
     */
    private String notes;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 别名
     */
    private String alias;

}