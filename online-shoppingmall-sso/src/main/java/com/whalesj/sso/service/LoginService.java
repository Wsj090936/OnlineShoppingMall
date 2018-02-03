package com.whalesj.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whalesj.common.pojo.TaotaoResult;

public interface LoginService {
	public TaotaoResult login(String username,String password,HttpServletRequest request,HttpServletResponse response);
	public TaotaoResult getUserByToken(String token);
}
