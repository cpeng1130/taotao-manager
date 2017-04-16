package com.taotao.service;

import org.springframework.stereotype.Service;

import com.taotao.common.utils.TaotaoResult;
@Service
public interface ItemParamService {

	TaotaoResult getItemParamByCid(Long cid);
	TaotaoResult InsertItemParam(Long cid,String paramData);
	
}
