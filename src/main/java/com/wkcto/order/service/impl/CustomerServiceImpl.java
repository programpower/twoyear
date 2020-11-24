package com.wkcto.order.service.impl;

import com.wkcto.order.entity.Customer;
import com.wkcto.order.mapper.CustomerMapper;
import com.wkcto.order.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 德鑫
 * @since 2020-08-03
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
