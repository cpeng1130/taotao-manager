package com.taotao.service;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;

@Service
public interface ItemService {
	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page,int rows);
	TaotaoResult createItem (TbItem item,String desc,String itemParam);
	String getItemParamHtml(Long itemId);
}
