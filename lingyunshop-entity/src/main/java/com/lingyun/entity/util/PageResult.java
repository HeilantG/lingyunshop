package com.lingyun.entity.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class PageResult<T> implements Serializable {
    private long total;//总记录数
    private List<T> rows;//当前页结果
}
