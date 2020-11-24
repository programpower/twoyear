package com.wkcto.plus;
import com.wkcto.plus.entity.Customer;
import com.wkcto.plus.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    //定义CustomerMapper
    @Autowired
    private CustomerMapper custDao;
    @Test
    public void testInsert(){
        Customer cust  = new Customer();
        cust.setCustName("张三");
        cust.setCustAge(28);
        cust.setCustEmail("zhangsan@163.com");

        int rows  = custDao.insert(cust);
        System.out.println("insert customer rows:"+rows);
    }


}
