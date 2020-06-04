package com.yautumn.controller;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.remot.springbootserver.ServiceFeignClient;
import com.yautumn.request.user.FindUserByIdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ServiceFeignClient saveUser;

    @PostMapping("/find/id")
    public ResultUtil findUserById(@RequestBody FindUserByIdRequest findUserByIdRequest){
        ResultUtil user = saveUser.getUserInfo(findUserByIdRequest);
        System.out.println(user.getResultMsg());
        return user;
    }
}
