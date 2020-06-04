package com.yautumn.remot.springbootserver.remote;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.remot.springbootserver.ServiceFeignClient;
import com.yautumn.request.user.FindUserByIdRequest;
import org.springframework.stereotype.Component;

@Component
public class ServiceFallback implements ServiceFeignClient {
    @Override
    public ResultUtil getUserInfo(FindUserByIdRequest findUserByIdRequest) {
        return ResultUtil.error("服务调用失败");
    }
}
