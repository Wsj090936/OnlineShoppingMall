package com.whalesj.rest.service.Impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.common.utils.JsonUtils;
import com.whalesj.mapper.TbContentMapper;
import com.whalesj.pojo.TbContent;
import com.whalesj.pojo.TbContentExample;
import com.whalesj.pojo.TbContentExample.Criteria;
import com.whalesj.rest.component.JedisClient;
import com.whalesj.rest.service.ContentService;

/**
 * 内容查询服务Service
 * @author wushijia
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private JedisClient jedisClient;//Jedis
	
	@Value("${REDIS_CONTENT_KEY}")
	private String REDIS_CONTENT_KEY;

	@Override
	public List<TbContent> getContentList(Long cid) {
		//轮播图添加缓存
		//查询数据库之前先查询缓存，如果有  直接返回，没有就查数据库
		try {
			//从redis中取缓存数据
			String json = jedisClient.hget(REDIS_CONTENT_KEY, cid+"");
			if(!StringUtils.isBlank(json)){
				//当不为空,将取出的字符串转换为pojo，然后直接返回
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		
		//返回之前先向缓存中添加数据
		try {
			//为了规范key，使用hash
			//定义hash的key，hash中每个项就是cid，value就是将list转换伪json数据
			jedisClient.hset(REDIS_CONTENT_KEY, cid+"", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public TaotaoResult synContent(Long cid) {
		Long res = jedisClient.hdel(REDIS_CONTENT_KEY, cid+"");
		return TaotaoResult.ok();
	}

}
