package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbBrand)实体类
 *
 * @author makejava
 * @since 2020-10-20 23:23:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class TbBrand implements Serializable {

    private Long id;
    /**
     * 品牌名称
     */
    private String name;
    /**
     * 品牌首字母
     */
    private String firstChar;

}