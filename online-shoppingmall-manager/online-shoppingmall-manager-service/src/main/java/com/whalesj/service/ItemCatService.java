package com.whalesj.service;

import java.util.List;

import com.whalesj.common.pojo.EasyUiTreeNode;

public interface ItemCatService {
	public List<EasyUiTreeNode> getItemCatList(long parentId);
}
