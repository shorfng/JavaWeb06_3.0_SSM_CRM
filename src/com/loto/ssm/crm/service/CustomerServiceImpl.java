package com.loto.ssm.crm.service;

import com.loto.ssm.crm.mapper.CustomerDao;
import com.loto.ssm.crm.pojo.Customer;
import com.loto.ssm.crm.pojo.QueryVo;
import com.loto.ssm.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    // 通过四个条件 查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();

        // 每页数
        page.setSize(5);
        vo.setSize(5);

        if (null != vo) {
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {
                vo.setCustName(vo.getCustName().trim());
            }
            if (null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
                vo.setCustLevel(vo.getCustLevel().trim());
            }

            page.setTotal(customerDao.customerCountByQueryVo(vo));      // 设置总条数
            page.setRows(customerDao.selectCustomerListByQueryVo(vo));  // 分页结果集
        }
        return page;
    }
}
