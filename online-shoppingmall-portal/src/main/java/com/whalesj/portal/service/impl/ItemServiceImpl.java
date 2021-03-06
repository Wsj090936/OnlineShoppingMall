package com.whalesj.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.common.utils.HttpClientUtil;
import com.whalesj.common.utils.JsonUtils;
import com.whalesj.pojo.TbItem;
import com.whalesj.pojo.TbItemDesc;
import com.whalesj.pojo.TbItemParamItem;
import com.whalesj.portal.service.ItemService;
import com.whalesj.protal.pojo.PortalItem;

/**
 * 调用rest工程发布的服务，查询商品信息
 * @author wushijia
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;//rest工程的基础url
	
	@Value("${REST_ITEM_BASE_URL}")
	private String REST_ITEM_BASE_URL;//请求服务的url
	
	@Value("${REST_ITEM_DESC_URL}")
	private String REST_ITEM_DESC_URL;//商品详细信息的 url
	
	@Value("${REST_ITEM_PARAM_URL}")
	private String REST_ITEM_PARAM_URL;//商品规格参数的 url

	@Override
	public TbItem getItemById(Long itemId) {
		//根据商品id查询商品的基本信息
		String json = HttpClientUtil.doGet(REST_BASE_URL+REST_ITEM_BASE_URL+itemId);
		//转换为java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, PortalItem.class);
		TbItem tbItem = (TbItem) taotaoResult.getData();
		return tbItem;
	}

	@Override
	public String getItemDescById(Long itemId) {
		//调用服务获得数据  http://localhost:8081/rest/item/desc/{itemId}
		String json = HttpClientUtil.doGet(REST_BASE_URL+REST_ITEM_DESC_URL+itemId);
		//转换为java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemDesc.class);
		//取信息
		TbItemDesc itemDesc =  (TbItemDesc) taotaoResult.getData();
		String string = itemDesc.getItemDesc();
		return string;
	}

	@Override
	public String getItemParamById(Long itemId) {
		//根据id获得规格参数
		String json = HttpClientUtil.doGet(REST_BASE_URL+REST_ITEM_PARAM_URL+itemId);
		//转换为java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemParamItem.class);
		//取规格参数
		TbItemParamItem itemParam =  (TbItemParamItem) taotaoResult.getData();
		String res = itemParam.getParamData();//得到规格参数的json数据
		//将json数据转换为java对象
		List<Map> paramList = JsonUtils.jsonToList(res, Map.class);
		
		// 表格生成
		StringBuffer sb = new StringBuffer();

		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
		sb.append("	<tbody>\n");
		for (Map map : paramList) {
			sb.append("		<tr>\n");
			sb.append("			<th class=\"tdTitle\" colspan=\"2\">" + map.get("group") + "</th>\n");
			sb.append("		</tr>\n");
			// 取规格项
		List<Map> mapList2 = (List<Map>) map.get("params");
		for (Map map2 : mapList2) {
				sb.append("		<tr>\n");
				sb.append("			<td class=\"tdTitle\">" + map2.get("k") + "</td>\n");
				sb.append("			<td>" + map2.get("v") + "</td>\n");
				sb.append("		</tr>\n");
			}
		}
		sb.append("	</tbody>\n");
		sb.append("</table>");
		
		return sb.toString();
	}

}
