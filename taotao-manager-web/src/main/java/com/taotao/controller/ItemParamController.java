package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemCatByCid(@PathVariable Long cid){
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;	
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData ){
		TaotaoResult result = itemParamService.InsertItemParam(cid, paramData);
		return result;
		
	}
}
