package com.taotao.service;

import org.springframework.stereotype.Service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
@Service
public interface  ContentService {
	TaotaoResult insertContent(TbContent content);
}
