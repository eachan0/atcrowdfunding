package com.atguigu.crowd.mysql.controller;

import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.mysql.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月19日
 * @desc ProjectRemoteController
 */
@RestController
public class ProjectRemoteController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/get/project/detail/remote/{projectId}")
    public AppResult<DetailProjectVO> getDetailProjectRemote(@PathVariable("projectId") Integer projectId) {
        DetailProjectVO detailProjectVO = projectService.getDetailProjectVO(projectId);
        return AppResult.success(detailProjectVO, 0);
    }

    @RequestMapping("/get/portal/type/project/data/remote")
    public AppResult<List<PortalTypeVO>> getPortalTypeProjectDataRemote() {
        List<PortalTypeVO> portalTypeVOList = projectService.getPortalTypeVO();
        return AppResult.success(portalTypeVOList, portalTypeVOList.size());
    }

    @RequestMapping("/save/project/vo/remote")
    public AppResult<String> saveProjectRemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
        // 调用“本地”Service执行保存
        projectService.saveProject(projectVO, memberId);
        return AppResult.success();
    }
}
