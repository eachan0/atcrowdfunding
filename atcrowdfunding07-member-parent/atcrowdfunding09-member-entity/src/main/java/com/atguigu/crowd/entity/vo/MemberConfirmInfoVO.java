package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月15日
 * @desc MemberConfirmInfoVO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {

    private static final long serialVersionUID = -8828860782811114665L;
    // 易付宝账号
    private String paynum;
    // 法人身份证号
    private String cardnum;
}
