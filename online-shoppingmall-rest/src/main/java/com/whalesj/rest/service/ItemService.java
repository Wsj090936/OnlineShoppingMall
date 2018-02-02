package com.whalesj.rest.service;

import com.whalesj.pojo.TbItem;
import com.whalesj.pojo.TbItemDesc;
import com.whalesj.pojo.TbItemParamItem;

public interface ItemService {
	public TbItem getItemById(Long itemId);
	public TbItemDesc getItemDescById(Long itemId);
	public TbItemParamItem getItemParamById(Long itemId);
}
