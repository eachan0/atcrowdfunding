package com.atguigu.crowd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_project")
public class ProjectEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 项目描述
     */
    @TableField("project_description")
    private String projectDescription;

    /**
     * 筹集金额
     */
    @TableField("money")
    private Long money;

    /**
     * 筹集天数
     */
    @TableField("day")
    private Integer day;

    /**
     * 0-即将开始，1-众筹中，2-众筹成功，3-众筹失败

     */
    @TableField("status")
    private Integer status;

    /**
     * 项目发起时间
     */
    @TableField("deploydate")
    private String deploydate;

    /**
     * 已筹集到的金额
     */
    @TableField("supportmoney")
    private Long supportmoney;

    /**
     * 支持人数
     */
    @TableField("supporter")
    private Integer supporter;

    /**
     * 百分比完成度
     */
    @TableField("completion")
    private Integer completion;

    /**
     * 发起人的会员id
     */
    @TableField("memberid")
    private Integer memberid;

    /**
     * 项目创建时间
     */
    @TableField("createdate")
    private String createdate;

    /**
     * 关注人数
     */
    @TableField("follower")
    private Integer follower;

    /**
     * 头图路径
     */
    @TableField("header_picture_path")
    private String headerPicturePath;


}
