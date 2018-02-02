package com.whalesj.protal.pojo;

import com.whalesj.pojo.TbItem;

public class PortalItem extends TbItem {

	public String[] getImages(){//数据库中图片的url用 逗号隔开了，因此需要这样写
		String images = this.getImage();
		if(images != null && !images.equals("")){
			String[] res = images.split(",");
			return res;
		}
		return null;
	}
}
