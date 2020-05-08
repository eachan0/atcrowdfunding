package com.atguigu.crowd.service;

import com.atguigu.crowd.entity.MenuEntity;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-07
 */
public interface MenuService extends IService<MenuEntity> {

    /**
     * 获取树形菜单
     * @return tree menu
     */
    Result<MenuEntity> treeMenu();
}
