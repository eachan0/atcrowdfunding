package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.AuthEntity;
import com.atguigu.crowd.mapper.AuthMapper;
import com.atguigu.crowd.service.AuthService;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-08
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, AuthEntity> implements AuthService {

    @Override
    public Result<List<Integer>> getAuthIdByRoleId(Integer rId) {
        List<Integer> list = this.baseMapper.selectAuthIdByRoleId(rId);
        return Result.success(list,list.size());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRoleAuthRelationship(Map<String, List<Integer>> map) {
        // 1.获取roleId的值
        List<Integer> roleIdList = map.get("roleId");
        if(CollectionUtils.isEmpty(roleIdList)) {
            return;
        }
        Integer roleId = roleIdList.get(0);

        // 2.删除旧关联关系数据
        this.baseMapper.deleteOldRelationship(roleId);

        // 3.获取authIdList
        List<Integer> authIdList = map.get("authIdArray");

        // 4.判断authIdList是否有效
        if(!CollectionUtils.isEmpty(authIdList)) {
            this.baseMapper.insertNewRelationship(roleId, authIdList);
        }
    }
}
