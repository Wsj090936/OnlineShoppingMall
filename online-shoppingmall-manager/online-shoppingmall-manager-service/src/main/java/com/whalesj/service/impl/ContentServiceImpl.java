package com.whalesj.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.mapper.TbContentMapper;
import com.whalesj.pojo.TbContent;
import com.whalesj.service.ContentService;
/**
 * 广告内容管理
 * @author wushijia
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Override
	public TaotaoResult insertContent(TbContent tbContent) {
		tbContent.setUpdated(new Date());
		tbContent.setCreated(new Date());
		//插入
		tbContentMapper.insert(tbContent);
		
		return TaotaoResult.ok();
	}

}
