package com.loto.ssm.crm.mapper;

import com.loto.ssm.crm.pojo.Customer;
import com.loto.ssm.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerDao {

	// 设置总条数
	public Integer customerCountByQueryVo(QueryVo vo);

	// 分页结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);

    // 通过ID查询客户
    public Customer selectCustomerById(Integer id);

    // 通过ID修改客户
    public void updateCustomerById(Customer customer);

}
