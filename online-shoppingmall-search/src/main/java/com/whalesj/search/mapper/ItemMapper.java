package com.whalesj.search.mapper;

import java.util.List;

import com.whalesj.search.pojo.SearchItem;

/**
 * 搜索服务器的Mapper
 * @author wushijia
 *
 */
public interface ItemMapper {
	public List<SearchItem> getItemList();
}
