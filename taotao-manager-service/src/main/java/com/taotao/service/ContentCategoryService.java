package com.taotao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.utils.TaotaoResult;

@Service
public interface ContentCategoryService {
	public List<EasyUITreeNode> getContentCatList(Long parentId); 
	TaotaoResult inserCategory(Long parentId, String name);
}
