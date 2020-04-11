package com.gxl.order.service;

import com.gxl.order.entity.Item;
import com.gxl.order.properties.OrderProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gxl
 * @version 1.0
 * @description 商品服务
 * @date 2019-08-09 09:09
 */
@Service
public class ItemService {

    /**
     * Spring框架对restful方式的http请求做了封装，来简化操作
     */
    private final RestTemplate restTemplate;

    private final OrderProperties orderProperties;

    public ItemService(RestTemplate restTemplate, OrderProperties orderProperties) {
        this.restTemplate = restTemplate;
        this.orderProperties = orderProperties;
    }

    @Value("${myspcloud.item.url}")
    private String itemUrl;

    @Deprecated
    public Item queryItemById1(Long id) {
        return this.restTemplate.getForObject(orderProperties.getItem().getUrl() + id, Item.class);
    }

    @Deprecated
    public Item queryItemById2(Long id) {
        // 该方法走eureka注册中心调用(这种方式必须先开启负载均衡@LoadBalanced)
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("订单系统调用商品服务,result:" + result);
        return result;
    }

    /**
     * 进行容错处理
     * fallbackMethod的方法参数个数类型要和原方法一致
     *
     * @param id id
     * @return Item
     */
    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemById(Long id) {
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("===========HystrixCommand queryItemById-线程池名称："
                + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
        return result;
    }

    /**
     * 请求失败执行的方法
     * fallbackMethod的方法参数个数类型要和原方法一致
     *
     * @param id id
     * @return Item
     */
    public Item queryItemByIdFallbackMethod(Long id) {
        return new Item(id, "查询商品信息出错!", null, null, null);
    }


}
