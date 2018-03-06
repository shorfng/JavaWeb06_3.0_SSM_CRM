package com.loto.ssm.crm.service;

import java.util.List;

import com.loto.ssm.crm.mapper.BaseDictDao;
import com.loto.ssm.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    public List<BaseDict> selectBaseDictListByCode(String code) {
        return baseDictDao.selectBaseDictListByCode(code);
    }


}
