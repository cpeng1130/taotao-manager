package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FastDFSClient;
import com.taotao.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService{

	@Value("${IMAGE_SERVER_BASE_URL}")
	private String IMAGE_SERVER_BASE_URL;

	public PictureResult uploadPic(MultipartFile picFile) {
		PictureResult result = new PictureResult();
		
		if(picFile.isEmpty()){
			result.setError(1);
			result.setMessage("file is empty");
			return result;
		}else{
			try {
				String originalFilename = picFile.getOriginalFilename();
				String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
				FastDFSClient client = new FastDFSClient("classpath:properties/client.conf");
				String url = client.uploadFile(picFile.getBytes(), extName);
				url=IMAGE_SERVER_BASE_URL+url;
				result.setError(0);
				result.setUrl(url);
				System.out.println("upload file successful");
				return result;
			} catch (Exception e) {
				
				e.printStackTrace();
				result.setError(1);
				result.setMessage("图片上传失败");
				return result;
			}
		}
	}

}
