package com.itzyzx.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itzyzx.gmall.bean.PmsSkuAttrValue;
import com.itzyzx.gmall.bean.PmsSkuImage;
import com.itzyzx.gmall.bean.PmsSkuInfo;
import com.itzyzx.gmall.bean.PmsSkuSaleAttrValue;
import com.itzyzx.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.itzyzx.gmall.manage.mapper.PmsSkuImageMapper;
import com.itzyzx.gmall.manage.mapper.PmsSkuInfoMapper;
import com.itzyzx.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.itzyzx.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @CLassName SkuServiceImpl
 * @Description: TODO
 * @date: 2020/3/26 16:47
 * @Version 1.0
 */
@Service
public class SkuServiceImpl implements SkuService {
	@Autowired
	PmsSkuInfoMapper pmsSkuInfoMapper;

	@Autowired
	PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

	@Autowired
	PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

	@Autowired
	PmsSkuImageMapper pmsSkuImageMapper;


	@Override
	public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

		// 插入skuInfo
		int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
		String skuId = pmsSkuInfo.getId();

		// 插入平台属性关联
		List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
		for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
			pmsSkuAttrValue.setSkuId(skuId);
			pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
		}

		// 插入销售属性关联
		List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
		for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
			pmsSkuSaleAttrValue.setSkuId(skuId);
			pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
		}

		// 插入图片信息
		List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
		for (PmsSkuImage pmsSkuImage : skuImageList) {
			pmsSkuImage.setSkuId(skuId);
			pmsSkuImageMapper.insertSelective(pmsSkuImage);
		}


	}
}

