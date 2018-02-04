package com.whalesj.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.common.utils.HttpClientUtil;
import com.whalesj.common.utils.JsonUtils;
import com.whalesj.portal.service.OrderService;
import com.whalesj.protal.pojo.OrderInfo;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;

	@Override
	public String createOrder(OrderInfo orderInfo) {
		//将orderInfo转换为json
		String json = JsonUtils.objectToJson(orderInfo);
		//提交订单数据
		String jsonResult = HttpClientUtil.doPostJson(ORDER_BASE_URL+ORDER_CREATE_URL, json);
		//转换为jsva对象
		TaotaoResult taotaoResult = TaotaoResult.format(jsonResult);
		String orderId = taotaoResult.getData().toString();
		return orderId;
	}

}
