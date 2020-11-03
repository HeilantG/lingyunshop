package com.lingyun.entity;

import java.io.Serializable;

/**
 * 内容分类(TbContentCategory)实体类
 *
 * @author makejava
 * @since 2020-11-03 15:43:29
 */
public class TbContentCategory implements Serializable {
    private static final long serialVersionUID = 935382162132488023L;
    /**
     * 类目ID
     */
    private Long id;
    /**
     * 分类名称
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}