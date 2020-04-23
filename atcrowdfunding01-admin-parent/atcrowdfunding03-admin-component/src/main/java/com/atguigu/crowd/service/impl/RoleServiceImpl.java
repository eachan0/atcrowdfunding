package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.RoleEntity;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.RoleService;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Override
    public Result<Page<RoleEntity>> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<RoleEntity> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(keyword)) {
            wrapper.like(RoleEntity::getName, keyword);
        }
        wrapper.orderByAsc(RoleEntity::getId);
        Page<RoleEntity> page = this.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(page, page.getTotal());
    }
}
