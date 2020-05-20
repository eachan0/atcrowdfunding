package com.atguigu.crowd.mysql.service.impl;

import com.atguigu.crowd.entity.po.*;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.mysql.mapper.ProjectMapper;
import com.atguigu.crowd.mysql.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-15
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements ProjectService {

    @Autowired
    private ProjectItemPicService itemPicService;

    @Autowired
    private ProjectTagService projectTagService;

    @Autowired
    private ProjectTypeService projectTypeService;

    @Autowired
    private MemberLaunchInfoService launchInfoService;

    @Autowired
    private ReturnService returnService;

    @Autowired
    private MemberConfirmInfoService confirmInfoService;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void saveProject(ProjectVO projectVO, Integer memberId) {
        // 一、保存ProjectPO对象
        // 1.创建空的ProjectPO对象
        ProjectEntity projectEntity = new ProjectEntity();

        // 2.把projectVO中的属性复制到projectPO中
        BeanUtils.copyProperties(projectVO, projectEntity);

        // 修复bug：把memberId设置到projectPO中
        projectEntity.setMemberid(memberId);

        // 修复bug：生成创建时间存入
        projectEntity.setCreatedate(DTF.format(LocalDate.now()));

        // 修复bug：status设置成0，表示即将开始
        projectEntity.setStatus(0);

        // 3.保存projectPO
        // 为了能够获取到projectPO保存后的自增主键，需要到ProjectPOMapper.xml文件中进行相关设置
        // <insert id="insertSelective" useGeneratedKeys="true" keyProperty="id" ……
        this.save(projectEntity);

        // 4.从projectPO对象这里获取自增主键
        Integer projectId = projectEntity.getId();

        // 二、保存项目、分类的关联关系信息
        // 1.从ProjectVO对象中获取typeIdList
        List<Integer> typeIdList = projectVO.getTypeIdList();
        List<ProjectTypeEntity> projectTypeEntities = typeIdList.stream().map(item -> new ProjectTypeEntity(projectId, item)).collect(Collectors.toList());
        projectTypeService.saveBatch(projectTypeEntities);

        // 三、保存项目、标签的关联关系信息
        List<Integer> tagIdList = projectVO.getTagIdList();
        List<ProjectTagEntity> projectTagEntities = tagIdList.stream().map(item -> new ProjectTagEntity(projectId, item)).collect(Collectors.toList());
        projectTagService.saveBatch(projectTagEntities);

        // 四、保存项目中详情图片路径信息
        List<String> detailPicturePathList = projectVO.getDetailPicturePathList();
        List<ProjectItemPicEntity> projectItemPicEntities = detailPicturePathList.stream().map(item -> new ProjectItemPicEntity(projectId, item)).collect(Collectors.toList());
        itemPicService.saveBatch(projectItemPicEntities);

        // 五、保存项目发起人信息
        MemberLauchInfoVO memberLauchInfoVO = projectVO.getMemberLauchInfoVO();
        MemberLaunchInfoEntity launchInfoEntity = new MemberLaunchInfoEntity();
        BeanUtils.copyProperties(memberLauchInfoVO, launchInfoEntity);
        launchInfoEntity.setMemberid(memberId);

        launchInfoService.save(launchInfoEntity);

        // 六、保存项目回报信息
        List<ReturnVO> returnVOList = projectVO.getReturnVOList();

        List<ReturnEntity> returnEntities = returnVOList.stream().map(item -> {
            ReturnEntity entity = new ReturnEntity();
            BeanUtils.copyProperties(item, entity);
            entity.setProjectid(projectId);
            return entity;
        }).collect(Collectors.toList());

        returnService.saveBatch(returnEntities);

        // 七、保存项目确认信息
        MemberConfirmInfoVO memberConfirmInfoVO = projectVO.getMemberConfirmInfoVO();
        MemberConfirmInfoEntity confirmInfoEntity = new MemberConfirmInfoEntity();
        BeanUtils.copyProperties(memberConfirmInfoVO, confirmInfoEntity);
        confirmInfoEntity.setMemberid(memberId);
        confirmInfoService.save(confirmInfoEntity);
    }

    @Override
    public List<PortalTypeVO> getPortalTypeVO() {
        return this.baseMapper.selectPortalTypeVOList();
    }

    @Override
    public DetailProjectVO getDetailProjectVO(Integer projectId) {

        // 1.查询得到DetailProjectVO对象
        DetailProjectVO detailProjectVO = this.baseMapper.selectDetailProjectVO(projectId);

        // 2.根据status确定statusText
        Integer status = detailProjectVO.getStatus();

        switch (status) {
            case 0:
                detailProjectVO.setStatusText("审核中");
                break;
            case 1:
                detailProjectVO.setStatusText("众筹中");
                break;
            case 2:
                detailProjectVO.setStatusText("众筹成功");
                break;
            case 3:
                detailProjectVO.setStatusText("已关闭");
                break;

            default:
                break;
        }

        // 3.根据deployeDate计算lastDay
        // 2020-10-15
        String deployDate = detailProjectVO.getDeployDate();

        // 获取当前日期
        Date currentDay = new Date();

        // 把众筹日期解析成Date类型
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date deployDay = format.parse(deployDate);

            // 获取当前当前日期的时间戳
            long currentTimeStamp = currentDay.getTime();

            // 获取众筹日期的时间戳
            long deployTimeStamp = deployDay.getTime();

            // 两个时间戳相减计算当前已经过去的时间
            long pastDays = (currentTimeStamp - deployTimeStamp) / 1000 / 60 / 60 / 24;

            // 获取总的众筹天数
            Integer totalDays = detailProjectVO.getDay();

            // 使用总的众筹天数减去已经过去的天数得到剩余天数
            Integer lastDay = (int) (totalDays - pastDays);

            detailProjectVO.setLastDay(lastDay);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return detailProjectVO;
    }
}
