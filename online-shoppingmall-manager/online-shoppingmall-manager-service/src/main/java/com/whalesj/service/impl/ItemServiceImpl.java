package com.whalesj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whalesj.common.pojo.EasyUiDateGridResult;
import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.common.utils.IDUtils;
import com.whalesj.mapper.TbItemDescMapper;
import com.whalesj.mapper.TbItemMapper;
import com.whalesj.pojo.TbItem;
import com.whalesj.pojo.TbItemDesc;
import com.whalesj.pojo.TbItemExample;
import com.whalesj.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
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
	@Override
	public TaotaoResult createItem(TbItem item, String desc) {
		//生成商品id
		long id = IDUtils.genItemId();
		//补全商品属性
		item.setId(id);
			//商品状态 1-正常，2-下架3-删除
			item.setStatus((byte)1);
			//创建时间和更新时间
			Date date = new Date();
			item.setCreated(date);
			item.setUpdated(date);
		//插入商品
		itemMapper.insert(item);
		//添加商品描述
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(id);//商品id
		itemDesc.setItemDesc(desc);//商品描述
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		//插入商品描述数据
		itemDescMapper.insert(itemDesc);
		
		return TaotaoResult.ok();//处理成功返回该对象
	}

}
