package com.whalesj.sso.service;

import com.whalesj.common.pojo.TaotaoResult;
import com.whalesj.pojo.TbUser;

public interface RegisterService {
	public TaotaoResult checkData(String param,int type);
	public TaotaoResult register(TbUser user);
}
