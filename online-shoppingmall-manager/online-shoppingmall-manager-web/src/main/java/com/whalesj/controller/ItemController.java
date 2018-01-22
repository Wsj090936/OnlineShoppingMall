package com.whalesj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.pojo.TbItem;
import com.whalesj.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId){
		TbItem item = itemService.getItem(itemId);
		return item;
	}
}
