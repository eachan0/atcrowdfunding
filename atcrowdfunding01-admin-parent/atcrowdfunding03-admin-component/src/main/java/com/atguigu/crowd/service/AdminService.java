package com.atguigu.crowd.service;

import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 管理员账户表 服务类
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-14
 */
public interface AdminService extends IService<AdminEntity> {

    /**
     * 管理员登录处理
     *
     * @param username 用户名
     * @param password 密码
     * @return 管理员信息
     */
    AdminEntity doLogin(String username, String password);

    /**
     * 分页获取管理员数据
     *
     * @param keyword  关键字
     * @param pageNum  当前页数
     * @param pageSize 分页大小
     * @return list
     */
    Page<AdminEntity> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 保存 Admin 用户
     *
     * @param entity 信息
     */
    void saveAdmin(AdminEntity entity);

    /**
     * 修改 Admin 用户
     *
     * @param entity 信息
     */
    void modifyAdmin(AdminEntity entity);

    /**
     * 保存管理员角色关系
     *
     * @param id       管理员id
     * @param roleList 角色id list
     */
    void saveAdminRoleRelationship(Integer id, List<Integer> roleList);
}
