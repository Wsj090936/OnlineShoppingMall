package com.whalesj.search.service;

import com.whalesj.search.pojo.SearchResult;

public interface SearchService {
	public SearchResult search(String queryString,int page,int rows ) throws Exception;
}
