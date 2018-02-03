package com.whalesj.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbUser;
import com.whalesj.sso.service.RegisterService;

/**
 * 用户注册接口Controller
 * @author wushijia
 *
 */
@Controller
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object checkDate(@PathVariable String param,@PathVariable Integer type,String callback){
		
		try {
			TaotaoResult taotaoResult = registerService.checkData(param, type);
			if(StringUtils.isNotBlank(callback)){
				//请求为jsonp调用
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(taotaoResult);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return taotaoResult;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "用户注册接口出错");
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult register(TbUser user){
		try {
			TaotaoResult taotaoResult = registerService.register(user);
			return taotaoResult;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "注册失败!");
		}
	}
}
