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
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_order_project")
public class OrderProjectEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 发起人
     */
    @TableField("launch_name")
    private String launchName;

    /**
     * 回报内容
     */
    @TableField("return_content")
    private String returnContent;

    /**
     * 回报数量
     */
    @TableField("return_count")
    private Integer returnCount;

    /**
     * 支持单价
     */
    @TableField("support_price")
    private Integer supportPrice;

    /**
     * 配送费用
     */
    @TableField("freight")
    private Integer freight;

    /**
     * 订单表的主键
     */
    @TableField("order_id")
    private Integer orderId;


}
