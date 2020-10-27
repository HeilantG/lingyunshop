package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbSpecification)实体类
 *
 * @author makejava
 * @since 2020-10-22 10:29:41
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class TbSpecification implements Serializable {
    private static final long serialVersionUID = 548352790671361159L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String specName;

}