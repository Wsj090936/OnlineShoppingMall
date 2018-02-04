package com.whalesj.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.whalesj.pojo.TbUser;
import com.whalesj.portal.service.UserService;


/**
 * 用户登陆拦截器
 * @author wushijia
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;
	
	@Value("${SSO_LOGIN_URL}")	//注意，需要在SpringMVC中配置扫描该地址对应属性文件，否则无法注入
	private String SSO_LOGIN_URL;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {//Handler执行之前执行
//        拦截请求的url         
//        从cookie中获取token
//        如果没有token就跳转到登陆界面
//        取到token，需要调用sso工程来查询用户信息
		TbUser user = userService.getUserByToken(request, response);
		if(user == null){
			//跳转到登陆页面
			response.sendRedirect(SSO_LOGIN_URL+"?redirectURL="+request.getRequestURI());//将拦截的url取出，存入重定向后的url，然后sso的Controller会获得参数，向该页面进行跳转
			return false;
		}
//        如果redis中的session已经过期，那么就跳转到登陆界面
//        如果没有过期，就放行

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {//返回Model之前执行
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {//完成处理之后执行
		// TODO Auto-generated method stub

	}

}
