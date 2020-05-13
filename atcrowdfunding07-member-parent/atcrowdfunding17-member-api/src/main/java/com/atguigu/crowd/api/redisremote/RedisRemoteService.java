package com.atguigu.crowd.api.redisremote;

import com.atguigu.crowd.common.entity.AppResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc RedisRemoteSerivce
 */
@FeignClient("atguigu-crowd-redis")
public interface RedisRemoteService {

    @PostMapping("/redis/remote/set/normal")
    AppResult<String> setRedisKeyValueRemote(@RequestParam("key") String key, @RequestParam("value") String value);

    @PostMapping("/redis/remote/set/timeout")
    AppResult<String> setRedisKeyValueRemoteWithTimeout(@RequestParam("key") String key, @RequestParam("value") String value,
            @RequestParam("time") long time, @RequestParam("timeUnix") TimeUnit timeUnit);

    @GetMapping("/redis/remote/key")
    AppResult<String> getRedisStringValueByKeyRemote(@RequestParam("key") String key);

    @DeleteMapping("/redis/remote/remove")
    AppResult<String> removeRedisKeyRemote(@RequestParam("key") String key);
}
