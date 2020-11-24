package com.wkcto.plus;

import com.wkcto.plus.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 德鑫
 * 2020/08/02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptARTest {

    @Test
    public void testARInsert(){
        //定义dept的实体

        Dept dept  = new Dept();
        dept.setName("行政部");
        dept.setMobile("010-66666666");
        dept.setManager(5);
        //调用实体对象自己的方法，完成对象自身到数据库的添加操作
        boolean flag = dept.insert();
        System.out.println("ar insert result:"+flag);
    }

    /**
     * 根据主键更新
     */
    @Test
    public void testARUPdate(){
        Dept dept  = new Dept();
         dept.setId(1);
        dept.setMobile("010-22222222");
        dept.setName("改为市场部");
        dept.setManager(2);
        boolean result = dept.updateById();

        System.out.println("ar updateById" + result);
    }

    @Test
    public void testARSelectById(){
        Dept dept = new Dept();

        //根据主键查询到记录返回对象，没有查询到返回null ,不写主键报错
        dept.setId(3);
        Dept dept1 = dept.selectById();

        System.out.println(dept1);
    }
}
