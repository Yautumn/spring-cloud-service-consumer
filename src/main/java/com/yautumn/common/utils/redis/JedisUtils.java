package com.yautumn.common.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class JedisUtils {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    public boolean expire(String key, long time){
        try {
            if (time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object getObject(String key){
        return key == null?null:redisTemplate.opsForValue().get(key);
    }

    public boolean setObject(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String getKeyStr(String pre,Integer id){
        StringBuffer sb = new StringBuffer();
        sb.append(pre);
        sb.append(id);
        return sb.toString();
    }
}
