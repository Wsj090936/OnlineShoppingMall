package com.whalesj.portal.service;

import com.whalesj.protal.pojo.SearchResult;

public interface SearchService {
	public  SearchResult search(String keyword,int page,int rows);
}
