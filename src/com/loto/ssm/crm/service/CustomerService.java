package com.loto.ssm.crm.service;

import com.loto.ssm.crm.pojo.Customer;
import com.loto.ssm.crm.pojo.QueryVo;
import com.loto.ssm.crm.utils.Page;

public interface CustomerService {
	
	// 通过四个条件 查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	// 通过ID查询客户
	public Customer selectCustomerById(Integer id);

	// 通过ID修改客户
	public void updateCustomerById(Customer customer);

	// 通过ID删除客户
	public void deleteCustomerById(Integer id);
}
