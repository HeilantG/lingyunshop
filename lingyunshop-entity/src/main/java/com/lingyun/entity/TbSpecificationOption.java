package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbSpecificationOption)实体类
 *
 * @author makejava
 * @since 2020-10-22 17:29:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class TbSpecificationOption implements Serializable {
    private static final long serialVersionUID = 592079175556603342L;
    /**
     * 规格项ID
     */
    private Long id;
    /**
     * 规格项名称
     */
    private String optionName;
    /**
     * 规格ID
     */
    private Long specId;
    /**
     * 排序值
     */
    private Integer orders;
}