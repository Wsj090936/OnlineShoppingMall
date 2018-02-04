package com.whalesj.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.order.pojo.OrderInfo;
import com.whalesj.order.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order/create",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createOrder(@RequestBody OrderInfo orderInfo){
		try {
			TaotaoResult result = orderService.createOrderInfo(orderInfo);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "订单创建出错！");
		}
	}
}
