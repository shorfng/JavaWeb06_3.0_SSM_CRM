package com.loto.ssm.crm.mapper;


import com.loto.ssm.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    // 查询
    public List<BaseDict> selectBaseDictListByCode(String code);
}
