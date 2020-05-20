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
@TableName("t_order")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    @TableField("order_num")
    private String orderNum;

    /**
     * 支付宝流水号
     */
    @TableField("pay_order_num")
    private String payOrderNum;

    /**
     * 订单金额
     */
    @TableField("order_amount")
    private Double orderAmount;

    /**
     * 是否开发票（0 不开，1 开）
     */
    @TableField("invoice")
    private Integer invoice;

    /**
     * 发票抬头
     */
    @TableField("invoice_title")
    private String invoiceTitle;

    /**
     * 订单备注
     */
    @TableField("order_remark")
    private String orderRemark;

    /**
     * 收货地址id
     */
    @TableField("address_id")
    private String addressId;


}
