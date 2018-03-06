package com.loto.ssm.crm.controller;

import com.loto.ssm.crm.pojo.BaseDict;
import com.loto.ssm.crm.service.BaseDictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 功能：客户管理
 *
 * @author 蓝田_Loto
 * @create 2018-03-06 00:55
 **/

@Controller
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;

    // 注解在成员变量上
    @Value("${fromType.code}")
    private String fromTypeCode;

    // 查询条件初始化
    // http://localhost:8080/JavaWeb06_3.0_SSM_CRM/customer/list
    @RequestMapping(value = "/customer/list")
    public String list(Model model) {

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        return "customer";
    }
}
