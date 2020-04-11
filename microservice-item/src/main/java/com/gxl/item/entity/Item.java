package com.gxl.item.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gxl
 * @version 1.0
 * @description 商品实体
 * @date 2019-08-09 08:52
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Item {

    private Long id;

    private String title;

    private String pic;

    private String desc;

    private Long price;
}
