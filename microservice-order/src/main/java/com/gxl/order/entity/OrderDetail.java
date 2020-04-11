package com.gxl.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gxl
 * @version 1.0
 * @description 订单详情
 * @date 2019-08-09 09:04
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class OrderDetail {

    private String orderId;

    private Item item = new Item();
}
