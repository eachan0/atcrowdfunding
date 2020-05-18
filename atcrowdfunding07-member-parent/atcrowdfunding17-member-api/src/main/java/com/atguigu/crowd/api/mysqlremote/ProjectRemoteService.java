package com.atguigu.crowd.api.mysqlremote;

import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.vo.ProjectVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月15日
 * @desc ProjectRemoteService
 */
@FeignClient("atguigu-crowd-mysql")
public interface ProjectRemoteService {

    @RequestMapping("/save/project/vo/remote")
    AppResult<String> saveProjectRemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);
}
