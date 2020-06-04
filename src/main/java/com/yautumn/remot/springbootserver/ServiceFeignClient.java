package com.yautumn.remot.springbootserver;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.remot.springbootserver.remote.ServiceFallback;
import com.yautumn.request.user.FindUserByIdRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "SPRINGBOOTSERVICE" , fallback = ServiceFallback.class)
public interface ServiceFeignClient {
    @RequestMapping(value ="/user/find/id",method = RequestMethod.POST)
    ResultUtil getUserInfo(@RequestBody FindUserByIdRequest findUserByIdRequest);
}
