package com.atguigu.crowd.auth.controller;

import cn.hutool.http.HttpStatus;
import com.atguigu.crowd.api.mysqlremote.MemberRemoteService;
import com.atguigu.crowd.api.redisremote.RedisRemoteService;
import com.atguigu.crowd.common.constant.AppConst;
import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.entity.dto.Member;
import com.atguigu.crowd.entity.po.MemberEntity;
import com.atguigu.crowd.entity.vo.MemberVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc ViewController
 */
@Controller
public class ViewController {

    public static final String HOST = "http://www.crowd.com";

    @Autowired
    private MemberRemoteService memberRemoteService;

    @Autowired
    private RedisRemoteService redisRemoteService;

    @GetMapping("/")
    public String showPortalPage() {
        // 这里实际开发中需要加载数据……
        return "portal";
    }

    @PostMapping("/auth/do/member/register")
    public String doMemberRegister(@Validated Member member, ModelMap modelMap) {

        // 1.获取用户输入的手机号
        String phoneNum = member.getPhoneNum();

        // 2.拼Redis中存储验证码的Key
        String key = AppConst.ATTR_PHONE_CODE_PREFIX + phoneNum;

        // 3.从Redis读取Key对应的value
        AppResult<String> appResult = redisRemoteService.getRedisStringValueByKeyRemote(key);

        // 4.检查查询操作是否有效
        int result = appResult.getStatus();
        if (result != HttpStatus.HTTP_OK) {
            modelMap.addAttribute(AppConst.ATTR_NAME_MESSAGE, appResult.getMessage());
            return "member-reg";
        }

        String redisCode = appResult.getData();

        if (!StringUtils.hasText(redisCode)) {
            modelMap.addAttribute(AppConst.ATTR_NAME_MESSAGE, AppConst.MESSAGE_CODE_NOT_EXISTS);
            return "member-reg";
        }

        // 5.如果从Redis能够查询到value则比较表单验证码和Redis验证码
        String formCode = member.getCode();

        if (!redisCode.equals(formCode)) {
            modelMap.addAttribute(AppConst.ATTR_NAME_MESSAGE, AppConst.MESSAGE_CODE_INVALID);
            return "member-reg";
        }

        // 6.如果验证码一致，则从Redis删除
        redisRemoteService.removeRedisKeyRemote(key);

        // 7.执行密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userpswdBeforeEncode = member.getUserpswd();
        String userpswdAfterEncode = passwordEncoder.encode(userpswdBeforeEncode);
        member.setUserpswd(userpswdAfterEncode);

        // 8.执行保存
        // ①创建空的MemberPO对象
        MemberEntity entity = new MemberEntity();

        // ②复制属性
        BeanUtils.copyProperties(member, entity);

        // ③调用远程方法
        AppResult<String> saveResult = memberRemoteService.saveMember(entity);

        if (saveResult.getStatus() != HttpStatus.HTTP_OK) {
            modelMap.addAttribute(AppConst.ATTR_NAME_MESSAGE, saveResult.getMessage());
            return "member-reg";
        }

        // 使用重定向避免刷新浏览器导致重新执行注册流程
        return "redirect:" + HOST + "/auth/member/to/login/page";
    }

    @PostMapping("/auth/member/do/login")
    public String doMemberLogin(@RequestParam String loginacct, @RequestParam String userpswd,
                                ModelMap modelMap, HttpSession session) {
        AppResult<MemberEntity> appResult = memberRemoteService.getByAcctRemote(loginacct);
        if (appResult.getStatus() != HttpStatus.HTTP_OK) {
            modelMap.addAttribute(AppConst.ATTR_NAME_MESSAGE, appResult.getMessage());
            return "member-login";
        }

        MemberEntity entity = appResult.getData();
        if (entity == null) {
            modelMap.addAttribute(AppConst.ATTR_NAME_MESSAGE, AppConst.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        // 2.比较密码
        String userpswdDataBase = entity.getUserpswd();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        boolean matcheResult = passwordEncoder.matches(userpswd, userpswdDataBase);

        if (!matcheResult) {
            modelMap.addAttribute(AppConst.ATTR_NAME_MESSAGE, AppConst.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        // 3.创建MemberLoginVO对象存入Session域
        MemberVO member = new MemberVO(entity.getId(), entity.getUsername(), entity.getEmail());
        session.setAttribute(AppConst.ATTR_NAME_LOGIN_MEMBER, member);

        return "redirect:" + HOST + "/auth/member/center/page";
    }

    @GetMapping("/auth/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + HOST;
    }
}
