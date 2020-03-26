package com.itzyzx.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itzyzx.gmall.bean.PmsBaseAttrInfo;
import com.itzyzx.gmall.bean.PmsBaseAttrValue;
import com.itzyzx.gmall.bean.PmsBaseSaleAttr;
import com.itzyzx.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.itzyzx.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.itzyzx.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.itzyzx.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

	@Autowired
	PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
	@Autowired
	PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

	@Autowired
	PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

	/**
	 * 获取平台属性列表
	 *
	 * @param catalog3Id
	 * @return
	 */
	@Override
	public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

		PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
		pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
		List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
		return pmsBaseAttrInfos;
	}

	@Override
	public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
		String id = pmsBaseAttrInfo.getId();
		if (StringUtils.isBlank(id)) {
			//id为空，保存操作
			//保存属性
			pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);//insert insertSelective 区别是否将null插入数据库
			//保存属性值
			List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
			for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
				pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());

				pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
			}
		} else {
			//id不空 ，修改
			//属性修改
			Example example=new Example(PmsBaseAttrInfo.class);
			example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
			pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

			//属性值修改
			//按照属性id删除所有属性值
			PmsBaseAttrValue pmsBaseAttrValueDel=new PmsBaseAttrValue();
			pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
			pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);

			//删除后将新得属性值插入
			List<PmsBaseAttrValue> attrValueList=pmsBaseAttrInfo.getAttrValueList();
			for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
				pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
			}
		}

		return "success";
	}

	@Override
	public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

		PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
		pmsBaseAttrValue.setAttrId(attrId);
		List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
		return pmsBaseAttrValues;
	}

	@Override
	public List<PmsBaseSaleAttr> baseSaleAttrList() {
		return pmsBaseSaleAttrMapper.selectAll();
	}
}