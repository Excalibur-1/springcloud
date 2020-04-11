package com.gxl.test;

import com.gxl.order.OrderApp;
import com.gxl.order.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author gxl
 * @version 1.0
 * @description TODO
 * @date 2019-08-10 19:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItemService.class)
@Import(OrderApp.class)
public class ItemServiceTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        String serviceId = "app-item";
        for (int i = 0; i < 100; i++) {
            ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
            System.out.println("第" + (i + 1) + "次：" + serviceInstance.getHost() + "：" + serviceInstance.getPort());
        }
    }
}
