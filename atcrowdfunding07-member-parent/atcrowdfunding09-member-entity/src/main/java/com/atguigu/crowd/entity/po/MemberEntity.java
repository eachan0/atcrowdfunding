package com.atguigu.crowd.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_member")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("loginacct")
    private String loginacct;

    @TableField("userpswd")
    private String userpswd;

    @TableField("username")
    private String username;

    @TableField("email")
    private String email;

    /**
     * 实名认证状态0 - 未实名认证， 1 - 实名认证申
请中， 2 - 已实名认证
     */
    @TableField("authstatus")
    private Integer authstatus;

    /**
     *  0 - 个人， 1 - 企业
     */
    @TableField("usertype")
    private Integer usertype;

    @TableField("realname")
    private String realname;

    @TableField("cardnum")
    private String cardnum;

    /**
     * 0 - 企业， 1 - 个体， 2 - 个人， 3 - 政府
     */
    @TableField("accttype")
    private Integer accttype;


}
