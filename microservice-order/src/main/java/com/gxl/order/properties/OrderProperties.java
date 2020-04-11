package com.gxl.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gxl
 * @version 1.0
 * @description 订单属性
 * @date 2019-08-09 09:27
 */
@Data
@Component
@ConfigurationProperties(prefix = "myspcloud")
public class OrderProperties {

    private ItemProperties item = new ItemProperties();
}
