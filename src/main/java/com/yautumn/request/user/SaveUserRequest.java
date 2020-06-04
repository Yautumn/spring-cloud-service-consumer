package com.yautumn.request.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SaveUserRequest {
    private String userName;

    private String userPassword;

    private String userSex;

}
