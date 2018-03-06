package com.loto.ssm.crm.service;

import com.loto.ssm.crm.pojo.Customer;
import com.loto.ssm.crm.pojo.QueryVo;
import com.loto.ssm.crm.utils.Page;

public interface CustomerService {
	
	// 通过四个条件 查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

}
