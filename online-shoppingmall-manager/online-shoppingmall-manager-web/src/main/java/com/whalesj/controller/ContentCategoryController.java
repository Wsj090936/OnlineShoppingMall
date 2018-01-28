package com.whalesj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.EasyUiTreeNode;
import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.service.ContentCategoryService;


/**
 * 内容分类管理Controller
 * @author wushijia
 *
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	@Autowired
	ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUiTreeNode> getContentList(@RequestParam(value="id",defaultValue="0") Long parentId){//将id的初始值设为0.即第一级节点
		List<EasyUiTreeNode> list = contentCategoryService.getContentCatList(parentId);
		return list;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createNode(Long parentId,String name){
		TaotaoResult result = contentCategoryService.insertCategory(parentId, name);
		return result;
	}
}
