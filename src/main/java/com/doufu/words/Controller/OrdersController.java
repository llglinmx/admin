package com.doufu.words.Controller;

import com.doufu.words.Controller.DTO.OrderParameter;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin() // 解决跨域访问
@RequestMapping(value = "admin/order")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    /*
     * 获取订单列表
     * */
    @RequestMapping(value = "orderList")
    public Result orderList(OrderParameter orderParameter) {
        return ordersService.orderList(orderParameter);
    }
}
