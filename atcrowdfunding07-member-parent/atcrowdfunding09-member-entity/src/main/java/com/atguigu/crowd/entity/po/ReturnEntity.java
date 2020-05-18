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
@TableName("t_return")
public class ReturnEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("projectid")
    private Integer projectid;

    /**
     * 0 - 实物回报， 1 虚拟物品回报
     */
    @TableField("type")
    private Integer type;

    /**
     * 支持金额
     */
    @TableField("supportmoney")
    private Integer supportmoney;

    /**
     * 回报内容
     */
    @TableField("content")
    private String content;

    /**
     * 回报产品限额，“0”为不限回报数量
     */
    @TableField("count")
    private Integer count;

    /**
     * 是否设置单笔限购
     */
    @TableField("signalpurchase")
    private Integer signalpurchase;

    /**
     * 具体限购数量
     */
    @TableField("purchase")
    private Integer purchase;

    /**
     * 运费，“0”为包邮
     */
    @TableField("freight")
    private Integer freight;

    /**
     * 0 - 不开发票， 1 - 开发票
     */
    @TableField("invoice")
    private Integer invoice;

    /**
     * 项目结束后多少天向支持者发送回报
     */
    @TableField("returndate")
    private Integer returndate;

    /**
     * 说明图片路径
     */
    @TableField("describ_pic_path")
    private String describPicPath;


}
