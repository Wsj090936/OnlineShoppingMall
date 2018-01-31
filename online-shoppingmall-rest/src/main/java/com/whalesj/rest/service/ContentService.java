package com.whalesj.rest.service;

import java.util.List;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbContent;

public interface ContentService {
	public List<TbContent> getContentList(Long cid);
	public TaotaoResult synContent(Long cid);//同步缓存和数据库中的内容
}
