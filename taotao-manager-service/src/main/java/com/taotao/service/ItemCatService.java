package com.taotao.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
@Service
public interface ItemCatService {
	
	public List<EasyUITreeNode> getItemCatList(Long parentId);
}
