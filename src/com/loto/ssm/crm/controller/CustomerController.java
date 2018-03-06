package com.loto.ssm.crm.controller;

import com.loto.ssm.crm.pojo.BaseDict;
import com.loto.ssm.crm.pojo.Customer;
import com.loto.ssm.crm.pojo.QueryVo;
import com.loto.ssm.crm.service.BaseDictService;

import com.loto.ssm.crm.service.CustomerService;
import com.loto.ssm.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private CustomerService customerService;

    // 注解在成员变量上
    @Value("${fromType.code}")
    private String fromTypeCode;

    // 查询条件初始化
    // http://localhost:8080/JavaWeb06_3.0_SSM_CRM/customer/list
    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo, Model model) {

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        // 通过四个条件，查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());

        return "customer";
    }

    // 去修改页面，回显数据
    @RequestMapping(value = "/customer/edit.action")
    public @ResponseBody
    Customer edit(Integer id){
        return customerService.selectCustomerById(id);
    }
}
