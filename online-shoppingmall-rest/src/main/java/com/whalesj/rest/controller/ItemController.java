package com.whalesj.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbItem;
import com.whalesj.pojo.TbItemDesc;
import com.whalesj.pojo.TbItemParamItem;
import com.whalesj.rest.service.ItemService;

/**
 * 商品管理Controller
 * @author wushijia
 *
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/base/{itemId}")
	@ResponseBody
	public TaotaoResult getItemById(@PathVariable Long itemId){
		try {
			TbItem tbItem = itemService.getItemById(itemId);
			return TaotaoResult.ok(tbItem);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "商品信息查询出错啦");
		}
	}
	
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDescById(@PathVariable Long itemId){
		
		try {
			TbItemDesc itemDesc = itemService.getItemDescById(itemId);
			return TaotaoResult.ok(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "商品详细信息查询出错啦");
		}

	}
	
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParamById(@PathVariable Long itemId){
		
		try {
			TbItemParamItem tbItemParamItem = itemService.getItemParamById(itemId);
			return TaotaoResult.ok(tbItemParamItem);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "商品规格参数查询出错啦");
		}
		
	}
}
