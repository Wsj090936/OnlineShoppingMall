package com.whalesj.service;

import com.whalesj.common.pojo.EasyUiDateGridResult;
import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbItem;

public interface ItemService {
	public TbItem getItem(Long itemid);
	
	EasyUiDateGridResult getItemList(int page,int rows);
	
	public TaotaoResult createItem(TbItem item,String desc);
}
