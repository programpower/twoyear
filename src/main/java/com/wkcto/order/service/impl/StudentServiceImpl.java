package com.wkcto.order.service.impl;

import com.wkcto.order.entity.Student;
import com.wkcto.order.mapper.StudentMapper;
import com.wkcto.order.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
