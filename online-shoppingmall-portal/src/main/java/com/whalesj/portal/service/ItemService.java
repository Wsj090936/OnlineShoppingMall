package com.whalesj.portal.service;

import com.whalesj.pojo.TbItem;

public interface ItemService {
	public TbItem getItemById(Long itemId);
	public String getItemDescById(Long itemId);
	public String getItemParamById(Long itemId);
}