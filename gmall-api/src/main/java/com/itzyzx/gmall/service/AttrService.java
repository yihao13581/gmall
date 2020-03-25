package com.itzyzx.gmall.service;

import com.itzyzx.gmall.bean.PmsBaseAttrInfo;
import com.itzyzx.gmall.bean.PmsBaseAttrValue;
import com.itzyzx.gmall.bean.PmsBaseSaleAttr;

import java.util.List;


public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
