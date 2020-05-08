package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.AdminEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 管理员账户表 Mapper 接口
 * </p>
 *
 * @author zhuyc
 * @since 2020-04-14
 */
public interface AdminMapper extends BaseMapper<AdminEntity> {

    /**
     * 删除对应关系
     *
     * @param id 管理员ID
     */
    void deleteRelationship(Integer id);

    /**
     * 保存对应关系
     *
     * @param id       管理员ID
     * @param roleList roleId list
     */
    void insertRelationship(@Param("id") Integer id, @Param("roleIds") List<Integer> roleList);
}
