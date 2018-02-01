package com.whalesj.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.common.utils.HttpClientUtil;
import com.whalesj.portal.service.SearchService;
import com.whalesj.protal.pojo.SearchResult;
/**
 * 调用搜索服务
 * @author wushijia
 *
 */
@Service
public class SearchServiceImpl implements SearchService {
	
	private static final String SearchResult = null;
	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;

	@Override
	public SearchResult search(String keyword, int page, int rows) {
		//调用服务查询商品
		Map<String, String> param = new HashMap<>();
		param.put("keyword", keyword);
		param.put("page", page+"");
		param.put("rows", rows+"");
		String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, SearchResult.class);
		SearchResult searchResult = (SearchResult)taotaoResult.getData();
		return searchResult;
	}

}
