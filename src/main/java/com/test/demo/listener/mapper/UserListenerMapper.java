package com.test.demo.listener.mapper;

import com.test.demo.user.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Mapper注解的的作用 1:为了把mapper这个DAO交給Spring管理
 * 2:为了不再写mapper映射文件
 * 3:为了给mapper接口 自动根据一个添加@Mapper注解的接口生成一个实现类
 */
@Mapper
public interface UserListenerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}