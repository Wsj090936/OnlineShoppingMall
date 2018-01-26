package com.whalesj.service;

import com.whalesj.common.pojo.EasyUiDateGridResult;
import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbItem;

public interface ItemService {
	public TbItem getItem(Long itemid);
	
	EasyUiDateGridResult getItemList(int page,int rows);//展示商品列表
	
	public TaotaoResult createItem(TbItem item,String desc,String itemParam);//添加商品
	
	public String getItemParamHtml(Long itemId);//商品的规格参数展示
}
