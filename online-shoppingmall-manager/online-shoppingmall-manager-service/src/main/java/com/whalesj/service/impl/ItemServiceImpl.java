package com.whalesj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whalesj.common.pojo.EasyUiDateGridResult;
import com.whalesj.mapper.TbItemMapper;
import com.whalesj.pojo.TbItem;
import com.whalesj.pojo.TbItemExample;
import com.whalesj.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItem(Long itemid) {
		TbItem item = itemMapper.selectByPrimaryKey(itemid);
		return item;
	}
	@Override
	public EasyUiDateGridResult getItemList(int page, int rows) {
		//1、分页处理
		PageHelper.startPage(page, rows);
		//2、执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);//无条件查询
		//3、处理结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);//取分页信息
		EasyUiDateGridResult result = new EasyUiDateGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}