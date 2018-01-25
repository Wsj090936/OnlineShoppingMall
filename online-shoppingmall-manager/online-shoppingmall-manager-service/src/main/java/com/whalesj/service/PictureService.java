package com.whalesj.service;

import org.springframework.web.multipart.MultipartFile;

import com.whalesj.common.pojo.PictureResult;

public interface PictureService {
	public PictureResult uploadPic(MultipartFile picfile);
}
