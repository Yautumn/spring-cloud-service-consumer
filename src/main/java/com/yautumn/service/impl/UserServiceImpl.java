package com.yautumn.service.impl;

import com.alibaba.fastjson.JSON;
import com.yautumn.common.entity.User;
import com.yautumn.common.utils.redis.JedisUtils;
import com.yautumn.dao.user.UserMapper;
import com.yautumn.request.user.FindUserByIdRequest;
import com.yautumn.request.user.SaveUserRequest;
import com.yautumn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisUtils jedisUtils;

    @Value("${redisprefix}")
    private String keyPre;

    @Override
    public int saveUser(SaveUserRequest saveUserRequest) {
        User user = new User();
        user.setUserName(saveUserRequest.getUserName());
        user.setUserPassword(saveUserRequest.getUserPassword());
        user.setUserSex(saveUserRequest.getUserSex());
        user.setUserBirthday(new Date());
        int val = userMapper.insert(user);
        return val;
    }
    public User getUserById(FindUserByIdRequest findUserByIdRequest){
        User user = null;
        boolean flag = jedisUtils.hasKey(jedisUtils.getKeyStr(keyPre,findUserByIdRequest.getId()));
        if (flag){
            String userStr = (String) jedisUtils.getObject(jedisUtils.getKeyStr(keyPre,findUserByIdRequest.getId()));
            user = JSON.parseObject(userStr,User.class);
        }else {
            user = userMapper.selectByPrimaryKey(findUserByIdRequest.getId());
            jedisUtils.setObject(jedisUtils.getKeyStr(keyPre,findUserByIdRequest.getId()), JSON.toJSONString(user));
        }
        return user;
    }
}
