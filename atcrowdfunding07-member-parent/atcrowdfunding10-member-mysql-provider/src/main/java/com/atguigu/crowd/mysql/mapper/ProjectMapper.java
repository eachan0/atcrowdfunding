package com.atguigu.crowd.mysql.mapper;

import com.atguigu.crowd.entity.po.ProjectEntity;
import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-15
 */
public interface ProjectMapper extends BaseMapper<ProjectEntity> {

    List<PortalTypeVO> selectPortalTypeVOList();

    DetailProjectVO selectDetailProjectVO(Integer projectId);
}
