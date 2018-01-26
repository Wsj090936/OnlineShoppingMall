package com.whalesj.service;

import com.whalesj.common.pojo.TaotaoResult;

public interface ItemParamService {
	TaotaoResult getParamByCid(Long cid);
	TaotaoResult insertItemParam(Long cid,String paramData);
}
