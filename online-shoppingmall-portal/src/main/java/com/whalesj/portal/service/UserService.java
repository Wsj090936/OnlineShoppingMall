package com.whalesj.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whalesj.pojo.TbUser;

public interface UserService {
	public TbUser getUserByToken(HttpServletRequest request,HttpServletResponse response);
}
