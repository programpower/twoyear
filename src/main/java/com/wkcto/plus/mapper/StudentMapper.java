package com.wkcto.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wkcto.plus.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 德鑫
 * 2020/08/03
 */

public interface StudentMapper extends BaseMapper<Student> {

    public Student selectStudentById(@Param("id") Integer id);
}
