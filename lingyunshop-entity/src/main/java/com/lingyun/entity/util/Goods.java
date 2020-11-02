package com.lingyun.entity.util;

import com.lingyun.entity.TbGoods;
import com.lingyun.entity.TbGoodsDesc;
import com.lingyun.entity.TbItem;
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
public class Goods implements Serializable {
    private TbGoods goods;//商品SPU
    private TbGoodsDesc goodsDesc;//商品扩展
    private List<TbItem> itemList;//商品SKU列表
}
