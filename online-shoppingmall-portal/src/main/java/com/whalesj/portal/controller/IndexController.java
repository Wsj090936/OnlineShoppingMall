package com.whalesj.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页访问
 * @author wushijia
 *
 */
@Controller
public class IndexController {
	@RequestMapping("index")
	public String showIndex(){
		return "index";
	}
}