package com.loto.ssm.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能：客户管理
 *
 * @author 蓝田_Loto
 * @create 2018-03-06 00:55
 **/

@Controller
public class CustomerController {
    // 入口
    // http://localhost:8080/JavaWeb06_3.0_SSM_CRM/customer/list
    @RequestMapping(value = "/customer/list")
    public String list() {

        return "customer";
    }
}
