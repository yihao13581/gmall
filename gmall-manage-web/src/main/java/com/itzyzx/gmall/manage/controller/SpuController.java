package com.itzyzx.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itzyzx.gmall.bean.PmsProductImage;
import com.itzyzx.gmall.bean.PmsProductInfo;
import com.itzyzx.gmall.bean.PmsProductSaleAttr;
import com.itzyzx.gmall.manage.util.PmsUploadUtil;
import com.itzyzx.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @CLassName SpuController
 * @Description: TODO
 * @date: 2020/3/24 10:57
 * @Version 1.0
 */
@Controller
@CrossOrigin
public class SpuController {

	@Reference
	SpuService spuService;

	@RequestMapping("spuImageList")
	@ResponseBody
	public List<PmsProductImage> spuImageList(String spuId){
		List<PmsProductImage> pmsProductImages=spuService.spuImageList(spuId);
		return pmsProductImages;
	}


	@RequestMapping("spuSaleAttrList")
	@ResponseBody
	public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){

		List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrList(spuId);
		return pmsProductSaleAttrs;
	}
	@RequestMapping("fileUpload")
	@ResponseBody
	public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
		// 将图片或者音视频上传到分布式的文件存储系统
		// 将图片的存储路径返回给页面
		//String imgUrl = "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";
		String imgUrl = PmsUploadUtil.uploadImage(multipartFile);
		System.out.println(imgUrl);
		return imgUrl;
	}

	@RequestMapping("saveSpuInfo")
	@ResponseBody
	public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {

		spuService.saveSpuInfo(pmsProductInfo);
		return "success";
	}

	@RequestMapping("spuList")
	@ResponseBody
	public List<PmsProductInfo> spuList(String catalog3Id) {

		List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);

		return pmsProductInfos;
	}
}
