package com.wkcto.plus;

import com.wkcto.plus.entity.User;
import com.wkcto.plus.mapper.UserMapper;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 德鑫
 * 2020/08/02
 */
@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlusApplicationTest {

    @Autowired
    private UserMapper userDao;

    //定义测试方法
    //测试添加操作， insert
    @Test
    public void testUserInsert(){
        //创建User对象
        for(int i=0;i<10;i++){
            User user  = new User();
            user.setName("zhangsan"+i);
            user.setAge(20 + i);
            user.setEmail("zhangsan@sina.com");
            //调用UserMapper的方法， 也就是父接口BaseMapper中的提供的方法
            int rows = userDao.insert(user);
            System.out.println("insert 的结果:"+rows);
        }
    }

    //添加数据后，获取主键值
    @Test
    public void testInsertGetId(){
        User user  = new User();
        user.setName("李四");
        user.setAge(20);
        user.setEmail("lisi@163.com");

        int rows  = userDao.insert(user);
        System.out.println("insert user rows:"+rows);

        //获取主键id ，刚添加数据库中的数据的id
        int id = user.getId();//主键字段对应的get方法
        System.out.println("主键id:"+id);

    }

    /**
     * 按条件删除数据， 条件是封装到Map对象中
     * 方法：deleteByMap(map对象);
     * 返回值：删除成功的记录数
     */
    @Test
    public void testDeleteByMap(){
        //创建Map对象，保存条件值
        Map<String,Object> map  = new HashMap<>();
        //put("表的字段名",条件值) ， 可以封装多个条件
        map.put("name","zs");
        map.put("age",20);
        //调用删除方法
        //DELETE FROM user WHERE name = ? AND age = ?
        int rows = userDao.deleteByMap(map);
        System.out.println("deleteByMap rows:"+rows);
    }
   @Test
    public void deleteBatchIds(){
//         List<Integer> ids  = new ArrayList<>();
//        ids.add(21);
//        ids.add(22);
//        ids.add(23);
//        ids.add(24);
//        ids.add(25);
       List<Integer> ids = Stream.of(21, 22, 23, 24, 25).collect(Collectors.toList());

       int i = userDao.deleteBatchIds(ids);
       System.out.println("deleteBatchs" + i);
   }

   //根据主键查询
    @Test
    public void testSelectById(){
        User user = new User();
        user = userDao.selectById(1);
        System.out.println("查询出来的user信息" + user);
    }
    /**
     * 使用lambda查询数据
     */
    @Test
    public void testSelectBatchId2(){
        List<Integer> ids = Stream.of(6, 9, 10, 15).collect(Collectors.toList());
        //SELECT id,name,email,age FROM user WHERE id IN ( ? , ? , ? , ? )
        List<User> users = userDao.selectBatchIds(ids);
        //遍历集合
        users.forEach( u -> {
            System.out.println("查询的user对象："+u);
        });
    }

    //map多条件
    @Test
    public void testSelectMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name", "zs");
        map.put("age", 20);

        List<User> users = userDao.selectByMap(map);
        users.forEach(u ->{
            System.out.println("selectMap " + u);
        });
    }

}
