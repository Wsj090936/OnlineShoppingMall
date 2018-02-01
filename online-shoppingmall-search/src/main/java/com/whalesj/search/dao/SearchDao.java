package com.whalesj.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.whalesj.search.pojo.SearchResult;

public interface SearchDao {
	public SearchResult search(SolrQuery query) throws Exception;
}
