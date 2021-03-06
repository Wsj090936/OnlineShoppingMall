package com.whalesj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.common.utils.HttpClientUtil;
import com.whalesj.pojo.TbContent;
import com.whalesj.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	//由于父容器不能向子容器中注入，因此需要在springMVC中配置扫描properties
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${REST_CONTENT_SYNC}")
	private String REST_CONTENT_SYNC;
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent tbContent){
		TaotaoResult result = contentService.insertContent(tbContent);
		
		//调用rest工程发布的服务来同步缓存
		HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC+tbContent.getCategoryId());
		return result;
	}
}
