package com.taotao.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
@Service
public interface PictureService {
	PictureResult uploadPic(MultipartFile picFile);
}
