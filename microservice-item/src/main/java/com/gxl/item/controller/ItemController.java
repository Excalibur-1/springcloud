package com.gxl.item.controller;

import com.gxl.item.entity.Item;
import com.gxl.item.service.ItemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gxl
 * @version 1.0
 * @description 商品控制器
 * @date 2019-08-09 08:55
 */
@RequestMapping("item")
@RestController
public class ItemController {

    @Value("${server.port}")
    private String port;

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * 对外提供接口服务，查询商品信息
     *
     * @param id 商品id
     * @return com.gxl.item.entity.Item
     */
    @GetMapping("{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        System.out.println("server port: " + port);
        return this.itemService.queryItemById(id);
    }
}
