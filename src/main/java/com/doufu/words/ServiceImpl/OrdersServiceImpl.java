package com.doufu.words.ServiceImpl;

import com.doufu.words.Controller.DTO.OrderParameter;
import com.doufu.words.Dao.OrdersRepository;
import com.doufu.words.Domain.Orders;
import com.doufu.words.Model.retrunType.PageDate;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Model.vo.TokenUtils;
import com.doufu.words.Service.OrdersService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersRepository ordersRepository;

    @Override
    public Result orderList(OrderParameter orderParameter) {

        Integer pagesIndex = orderParameter.getPageIndex() - 1;
        Integer pageSize = orderParameter.getPageSize();
        Pageable pageable = PageRequest.of(pagesIndex, pageSize);
        PageDate pageDate = new PageDate();
        Long count = null;
        List<Orders> ordersList = null;

        //全部数据
        count = ordersRepository.count();
        ordersList = ordersRepository.findAllByOrderByOrderCreateTimeDesc(pageable);
        pageDate.setCount(count);
        pageDate.setPageIndex(pagesIndex);
        pageDate.setPageSize(pageSize);

        pageDate.setDataList(ordersList);
        if (ordersList.size() <= 0) {
            return Result.createFail("暂无数据");
        }

        return Result.createSuccess("订单列表获取成功", pageDate);
    }
}
