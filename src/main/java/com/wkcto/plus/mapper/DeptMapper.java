package com.wkcto.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wkcto.plus.entity.Dept;

/**
 * 自定义Mapper,就是Dao接口。
 * 1.要实现BaseMapper
 * 2.指定实体类
 * <p>
 * BaseMapper是MP框架中的对象，定义17个操作方法（CRUD）
 */
public interface DeptMapper extends BaseMapper<Dept> {

}
