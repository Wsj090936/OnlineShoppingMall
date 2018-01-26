package com.whalesj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.service.ItemParamService;

/**
 * 商品规格参数模板管理Controller
 * @author wushijia
 *
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;
	
	
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemByCid(@PathVariable Long cid){
		TaotaoResult result = itemParamService.getParamByCid(cid);
		return result;
	}
	@RequestMapping("/cid/{cid}")
	@ResponseBody
	public TaotaoResult getItemByCid1(@PathVariable Long cid){
		TaotaoResult result = itemParamService.getParamByCid(cid);
		return result;
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){
		TaotaoResult result = itemParamService.insertItemParam(cid, paramData);
		return result;
	}
}
