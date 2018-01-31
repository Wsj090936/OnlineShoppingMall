package com.whalesj.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbContent;
import com.whalesj.rest.service.ContentService;

@Controller
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/{cid}")
	@ResponseBody
	public 	TaotaoResult getContentList(@PathVariable Long cid){
		try {
			List<TbContent> list = contentService.getContentList(cid);
			return TaotaoResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "出错了！请重试");
		}
	}
	@RequestMapping("/sync/content/{cid}")
	@ResponseBody
	public TaotaoResult synContent(@PathVariable Long cid){
		try {
			TaotaoResult result = contentService.synContent(cid);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "出错啦！");
		}
	}
}
