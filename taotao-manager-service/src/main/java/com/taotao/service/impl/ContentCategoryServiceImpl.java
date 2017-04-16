package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCatList(Long parentId) {

		// 根据parentId查询子节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);

		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		//转换成EasyUITreeNode列表
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			//创建一EasyUITreeNode节点
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			//添加到列表
			resultList.add(node);
		}

		return resultList;
	}

	@Override
	public TaotaoResult inserCategory(Long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setParentId(parentId);
		contentCategory.setStatus(1);
		contentCategory.setIsParent(false);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		contentCategoryMapper.insert(contentCategory);
		
		Long id = contentCategory.getId();
		
		TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
		
		if(!parentNode.getIsParent()){
			parentNode.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		return TaotaoResult.ok(id);
	}

}
