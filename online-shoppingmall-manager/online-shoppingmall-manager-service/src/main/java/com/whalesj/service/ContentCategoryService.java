package com.whalesj.service;

import java.util.List;

import com.whalesj.common.pojo.EasyUiTreeNode;
import com.whalesj.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	public List<EasyUiTreeNode> getContentCatList(Long parentId);
	
	public TaotaoResult insertCategory(Long parentId ,String name);
}
