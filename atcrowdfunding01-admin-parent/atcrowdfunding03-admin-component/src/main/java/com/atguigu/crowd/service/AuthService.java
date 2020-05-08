package com.atguigu.crowd.service;

import com.atguigu.crowd.entity.AuthEntity;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-08
 */
public interface AuthService extends IService<AuthEntity> {

    /**
     * 获取已分配的权限Id
     *
     * @param rId 角色Id
     * @return id list
     */
    Result<List<Integer>> getAuthIdByRoleId(Integer rId);

    /**
     * 保存角色权限对应关系
     *
     * @param map 对应数据
     */
    void saveRoleAuthRelationship(Map<String, List<Integer>> map);
}
