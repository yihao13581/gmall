package com.itzyzx.gmall.service;

import com.itzyzx.gmall.bean.PmsProductInfo;

import java.util.List;

/**
 * @CLassName SpuService
 * @Description: TODO
 * @date: 2020/3/24 10:29
 * @Version 1.0
 */
public interface SpuService {
	List<PmsProductInfo> spuList(String catalog3Id);
}
