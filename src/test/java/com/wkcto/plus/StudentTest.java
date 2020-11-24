package com.wkcto.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wkcto.plus.entity.Student;

import com.wkcto.plus.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 德鑫
 * 2020/08/03
 */
@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentMapper studentDao;

    //定义测试方法
    //测试添加操作， insert
    @Test
    public void testUserInsert(){
        //创建User对象
        for(int i=0;i<10;i++){
            Student student = new Student();
            student.setName("zs"+i);
            student.setAge(22+i);
            student.setEmail("zs@163.com"+i);
            student.setStatus(1);
            int rows =  studentDao.insert(student);
            System.out.println("insert 的结果:"+rows);
        }
    }

    @Test
    public void testSelectById(){
        Student student = studentDao.selectStudentById(1);
        System.out.println(student);
    }

    @Test
    public void testAllEq() {
        QueryWrapper<Student> qw = new QueryWrapper<>();
        //组装条件
        Map<String, Object> param = new HashMap<>();
        //map<key,value> key列名 , value：查询的值
        param.put("name", "zs");
        param.put("age", 28);
        param.put("status", 2);

        qw.allEq(param);
        //调用MP自己的查询方法
        //SELECT id,name,age,email,status FROM student WHERE name = ? AND age = ?
        //WHERE name = ? AND age = ? AND status = ?
        List<Student> students = studentDao.selectList(qw);
        students.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void testGt(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.gt("age", 20);
        List<Student> students = studentDao.selectList(qw);
        students.forEach(stu ->{
            System.out.println("stu:" + stu);
        });
    }

    @Test
    public void testlt(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.lt("age", 30);
        List<Student> students = studentDao.selectList(qw);
        students.forEach(stu ->{
            System.out.println("stu:" + stu);
        });
    }

    @Test
    public void testRight(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.likeRight("name", "l");
        List<Student> students = studentDao.selectList(qw);
        students.forEach(student -> System.out.println(student));
    }

    /**
     * inSql() : 使用子查询
     */
    @Test
    public void testInSQL(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        //WHERE age IN (select age from student where id=1)
        qw.inSql("age","select age from student where id=1");
        List<Student> students = studentDao.selectList(qw);
        students.forEach(stu -> System.out.println("stu" + stu));
    }

    @Test
    public void testOrder(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.orderBy(true,true,"name")
                .orderBy(true,false,"age")
                .orderBy(true,false,"email");
        // name asc, age desc , email desc
        //FROM student ORDER BY name ASC , age DESC , email DESC
        List<Student> students = studentDao.selectList(qw);
        students.forEach(stu -> System.out.println(stu));
    }

    /**
     * and ,or方法
     */
    @Test
    public void testOr(){
        QueryWrapper<Student> qw= new QueryWrapper<>();
        //WHERE name = ? OR age = ?
        qw.eq("name","张三")
                .or()
                .eq("age",22);
        List<Student> students = studentDao.selectList(qw);
        students.forEach(stu -> System.out.println(stu));
    }

    @Test

    public void testPages(){
        QueryWrapper qw = new QueryWrapper();

        qw.gt("age", 11);
        IPage<Student> page = new Page<>();
        //设置分页的数据
        page.setCurrent(1);
        page.setSize(3);

        IPage<Student> result = studentDao.selectPage(page, qw);

        List<Student> students = result.getRecords();
        System.out.println(students.size());

        //分页的信息
        long pages  = result.getPages();
        System.out.println("页数："+pages);
        System.out.println("总记录数："+result.getTotal());
        System.out.println("当前页码："+result.getCurrent());
        System.out.println("每页的记录数："+result.getSize());

    }
}
