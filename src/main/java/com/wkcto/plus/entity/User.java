package com.wkcto.plus.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 德鑫
 * 2020/08/01
 */

public class User {
//定义属性： 属性名和表中的列名一样
    /**
     * 指定主键的方式：
     * value:主键字段的名称， 如果是id，可以不用写。
     * type:指定主键的类型， 主键的值如何生成。 idType.AUTO 表示自动增长。
     */
    @TableId(
            value="id",
            type = IdType.AUTO
    )
    private Integer id;
    private String name;  // null
    private String email;
    //实体类属性，推荐使用包装类型， 可以判断是否为 null
    private Integer age; // 0

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

}
