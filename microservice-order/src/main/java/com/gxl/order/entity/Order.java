package com.gxl.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author gxl
 * @version 1.0
 * @description 订单实体
 * @date 2019-08-09 09:02
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Order {

    private String orderId;

    private Long userId;

    private Date createDate;

    private Date updateDate;

    private List<OrderDetail> orderDetails;
}
