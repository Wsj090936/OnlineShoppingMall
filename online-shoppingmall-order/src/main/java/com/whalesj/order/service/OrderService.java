package com.whalesj.order.service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.order.pojo.OrderInfo;

public interface OrderService {
	public TaotaoResult createOrderInfo(OrderInfo orderInfo);
}
