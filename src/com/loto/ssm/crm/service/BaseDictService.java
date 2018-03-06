package com.loto.ssm.crm.service;

import com.loto.ssm.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {

	// 查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
