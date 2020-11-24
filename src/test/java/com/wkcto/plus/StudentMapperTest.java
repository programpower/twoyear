package com.wkcto.plus;

import com.wkcto.order.entity.Student;
import com.wkcto.order.mapper.StudentMapper;
import com.wkcto.plus.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 德鑫
 * 2020/08/02
 */
@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {


    @Autowired
    private StudentMapper studentDao;

    @Test
    public void testSelectStudentMapper(){

        Student student = studentDao.selectById(1);
        System.out.println("查询出来的Student" + student);

    }

}
