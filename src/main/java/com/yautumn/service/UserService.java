package com.yautumn.service;

import com.yautumn.common.entity.User;
import com.yautumn.request.user.FindUserByIdRequest;
import com.yautumn.request.user.SaveUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int saveUser(SaveUserRequest saveUserRequest);

    User getUserById(FindUserByIdRequest findUserByIdRequest);
}
