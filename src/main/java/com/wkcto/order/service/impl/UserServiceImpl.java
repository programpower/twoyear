package com.wkcto.order.service.impl;

import com.wkcto.order.entity.User;
import com.wkcto.order.mapper.UserMapper;
import com.wkcto.order.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
