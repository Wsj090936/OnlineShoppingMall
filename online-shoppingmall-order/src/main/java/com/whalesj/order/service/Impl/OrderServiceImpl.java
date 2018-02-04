package com.whalesj.order.service.Impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.mapper.TbOrderItemMapper;
import com.whalesj.mapper.TbOrderMapper;
import com.whalesj.mapper.TbOrderShippingMapper;
import com.whalesj.order.component.JedisClient;
import com.whalesj.order.pojo.OrderInfo;
import com.whalesj.order.service.OrderService;
import com.whalesj.pojo.TbOrderItem;
import com.whalesj.pojo.TbOrderShipping;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderItemMapper orderItemMapper;//订单明细
	
	@Autowired
	private TbOrderMapper orderMapper;//订单表
	
	@Autowired
	private TbOrderShippingMapper shippingMapper;//明细表
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_ORDER_GEN_KEY}")
	private String REDIS_ORDER_GEN_KEY;//redis中订单id的key
	@Value("${ORDER_ID_BEGIN}")
	private String ORDER_ID_BEGIN;//redis中订单id的初始值
	@Value("${REDIS_ORDER_DETAIL_GEN_KEY}")
	private String REDIS_ORDER_DETAIL_GEN_KEY;
	
	
	@Override
	public TaotaoResult createOrderInfo(OrderInfo orderInfo) {
		//生成订单号
		String orderid = jedisClient.get(REDIS_ORDER_GEN_KEY);
		if(StringUtils.isBlank(orderid)){//如果订单号初始值不存在，要给其设置
			jedisClient.set(REDIS_ORDER_GEN_KEY, ORDER_ID_BEGIN);
		}
		Long orderId = jedisClient.incr(REDIS_ORDER_GEN_KEY);//将刚刚设置的key值加一
		//补全字段
		orderInfo.setOrderId(orderId.toString());
		//状态：1未付款  2已付款  3未发货  4已发货 5交易成功  6交易关闭
		orderInfo.setStatus(1);
		Date date = new Date();
		orderInfo.setUpdateTime(date);
		orderInfo.setCreateTime(date);
		//插入订单
		orderMapper.insert(orderInfo);
		
		//插入订单明细
		List<TbOrderItem> orderItems = orderInfo.getOrderItems();
		for (TbOrderItem orderItem : orderItems) {
			//生成明细id
			Long detailId = jedisClient.incr(REDIS_ORDER_DETAIL_GEN_KEY);
			orderItem.setId(detailId.toString());
			//订单号
			orderItem.setOrderId(orderId.toString());
			//插入数据
			orderItemMapper.insert(orderItem);
			
		}
		//插入物流表
		TbOrderShipping tbOrderShipping = orderInfo.getOrderShipping();
		tbOrderShipping.setOrderId(orderId.toString());
		tbOrderShipping.setCreated(date);
		tbOrderShipping.setUpdated(date);
		//插入数据
		shippingMapper.insert(tbOrderShipping);
		//包装反回
		return TaotaoResult.ok(orderId);
	}

}