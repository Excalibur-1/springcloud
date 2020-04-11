package com.gxl.order.service;

import com.gxl.order.entity.Item;
import com.gxl.order.entity.Order;
import com.gxl.order.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gxl
 * @version 1.0
 * @description TODO
 * @date 2019-08-09 09:06
 */
@Service
public class OrderService {

    private static final Map<String, Order> ORDER_DATA = new HashMap<>();

    static {
        // 模拟数据库，构造测试数据
        Order order1 = new Order();
        order1.setOrderId("201810300001");
        order1.setCreateDate(new Date());
        order1.setUpdateDate(order1.getCreateDate());
        order1.setUserId(1L);
        List<OrderDetail> orderDetails1 = new ArrayList<>();

        // 此处并没有商品的数据，只是保存了商品ID，需要调用商品微服务获取
        Item item = new Item();
        item.setId(1L);
        orderDetails1.add(new OrderDetail(order1.getOrderId(), item));

        // 构造第二个商品数据
        item = new Item();
        item.setId(6L);
        orderDetails1.add(new OrderDetail(order1.getOrderId(), item));
        order1.setOrderDetails(orderDetails1);
        ORDER_DATA.put(order1.getOrderId(), order1);

        Order order2 = new Order();
        order2.setOrderId("201810300002");
        order2.setCreateDate(new Date());
        order2.setUpdateDate(order2.getCreateDate());
        order2.setUserId(3L);
        List<OrderDetail> orderDetails2 = new ArrayList<>();

        // 此处并没有商品的数据，只是保存了商品ID，需要调用商品微服务获取
        Item item2 = new Item();
        item2.setId(3L);
        orderDetails2.add(new OrderDetail(order2.getOrderId(), item2));

        // 构造第二个商品数据
        item2 = new Item();
        item2.setId(5L);
        orderDetails2.add(new OrderDetail(order2.getOrderId(), item2));
        order2.setOrderDetails(orderDetails2);
        ORDER_DATA.put(order2.getOrderId(), order2);
    }

    private final ItemService itemService;

    public OrderService(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * 根据订单id查询订单数据
     *
     * @param orderId 订单id
     * @return com.gxl.order.entity.Order
     */
    public Order queryOrderById(String orderId) {
        Order order = ORDER_DATA.get(orderId);
        if (null == order) {
            return null;
        }
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            // 通过商品微服务查询商品详细数据
            Item item = this.itemService.queryItemById2(orderDetail.getItem()
                    .getId());
            if (null == item) {
                continue;
            }
            orderDetail.setItem(item);
        }

        return order;
    }

    public Order queryOrderByIdx(String orderId) {
        Order order = ORDER_DATA.get(orderId);
        if (null == order) {
            return null;
        }
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            // 通过商品微服务查询商品详细数据
            Item item = this.itemService.queryItemById(orderDetail.getItem()
                    .getId());
            if (null == item) {
                continue;
            }
            orderDetail.setItem(item);
        }

        return order;
    }

}

