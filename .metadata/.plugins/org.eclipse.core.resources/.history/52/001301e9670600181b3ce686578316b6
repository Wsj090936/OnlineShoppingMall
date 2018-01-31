package com.whalesj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbContent;
import com.whalesj.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent tbContent){
		TaotaoResult result = contentService.insertContent(tbContent);
		return result;
	}
}
