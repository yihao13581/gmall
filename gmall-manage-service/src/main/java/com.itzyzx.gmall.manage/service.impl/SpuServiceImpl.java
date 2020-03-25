package com.itzyzx.gmall.manage.service.impl;

/**
 * @CLassName SpuServiceImpl
 * @Description: TODO
 * @date: 2020/3/24 10:48
 * @Version 1.0
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.itzyzx.gmall.bean.PmsProductInfo;
import com.itzyzx.gmall.manage.mapper.PmsProductInfoMapper;
import com.itzyzx.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {
	@Autowired
	PmsProductInfoMapper pmsProductInfoMapper;
	@Override
	public List<PmsProductInfo> spuList(String catalog3Id) {
		PmsProductInfo pmsProductInfo = new PmsProductInfo();
		pmsProductInfo.setCatalog3Id(catalog3Id);
		List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);

		return pmsProductInfos;
	}
}
