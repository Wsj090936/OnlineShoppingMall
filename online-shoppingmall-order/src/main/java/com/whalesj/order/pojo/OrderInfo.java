package com.whalesj.order.pojo;

import java.util.List;

import com.whalesj.pojo.TbOrder;
import com.whalesj.pojo.TbOrderItem;
import com.whalesj.pojo.TbOrderShipping;

public class OrderInfo extends TbOrder {
	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;
	
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}

}
