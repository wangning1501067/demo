package com.test.demo.listener.service.impl;

import com.test.demo.listener.mapper.UserListenerMapper;
import com.test.demo.listener.service.UserListenerService;
import com.test.demo.user.event.MyEvent;
import com.test.demo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserListenerServiceImpl implements UserListenerService {

    @Autowired
    private UserListenerMapper userMapper;

    /**
     * 上下文对象
     */
    @Resource
    private ApplicationContext applicationContext;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return this.userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return this.userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        //通过上下文对象发布监听
        applicationContext.publishEvent(new MyEvent(this, "监听到没"));
        //System.out.println("监听到没");
        //return this.userMapper.selectByPrimaryKey(id);
        return new User("王宁", "123456");
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return this.userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }
}