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
@TableName("t_member_launch_info")
public class MemberLaunchInfoEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员id
     */
    @TableField("memberid")
    private Integer memberid;

    /**
     * 简单介绍
     */
    @TableField("description_simple")
    private String descriptionSimple;

    /**
     * 详细介绍
     */
    @TableField("description_detail")
    private String descriptionDetail;

    /**
     * 联系电话
     */
    @TableField("phone_num")
    private String phoneNum;

    /**
     * 客服电话
     */
    @TableField("service_num")
    private String serviceNum;


}
