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
@TableName("t_member_confirm_info")
public class MemberConfirmInfoEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员id
     */
    @TableField("memberid")
    private Integer memberid;

    /**
     * 易付宝企业账号
     */
    @TableField("paynum")
    private String paynum;

    /**
     * 法人身份证号
     */
    @TableField("cardnum")
    private String cardnum;


}
