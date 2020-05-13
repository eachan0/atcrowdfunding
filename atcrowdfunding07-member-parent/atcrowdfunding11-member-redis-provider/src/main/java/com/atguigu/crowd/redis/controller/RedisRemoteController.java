package com.atguigu.crowd.redis.controller;

import com.atguigu.crowd.common.entity.AppResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc RedisRemoteController
 */
@RestController
@RequestMapping("redis/remote")
public class RedisRemoteController {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @PostMapping("set/normal")
    AppResult<String> setRedisKeyValueRemote(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return AppResult.success();
    }

    @PostMapping("set/timeout")
    AppResult<String> setRedisKeyValueRemoteWithTimeout(@RequestParam("key") String key, @RequestParam("value") String value,
                                                        @RequestParam("time") long time, @RequestParam("timeUnix") TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
        return AppResult.success();
    }

    @GetMapping("key")
    AppResult<String> getRedisStringValueByKeyRemote(@RequestParam("key") String key) {
        String s = redisTemplate.opsForValue().get(key);
        return AppResult.success(s, 0);
    }

    @DeleteMapping("remove")
    AppResult<String> removeRedisKeyRemote(@RequestParam("key") String key){
        redisTemplate.delete(key);
        return AppResult.success();
    }
}
