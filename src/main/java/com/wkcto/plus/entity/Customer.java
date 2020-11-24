package com.wkcto.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 德鑫
 * 2020/08/03
 */
//当数据库字段名需要采用驼峰命名法
@TableName(value = "customer")
public class Customer {
    //定义属性
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    private String custName;//cust_name
    private int custAge;
    private String custEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustAge() {
        return custAge;
    }

    public void setCustAge(int custAge) {
        this.custAge = custAge;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", custAge=" + custAge +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }

}
