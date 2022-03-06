package com.october.wiki.modules.system.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.october.wiki.modules.system.entity.SysUser;
import com.october.wiki.modules.system.service.ISysUserService;
import com.october.wiki.modules.system.service.ISysUserTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 账号相关接口
 */
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final ISysUserService sysUserService;
    private final ISysUserTokenService sysUserTokenService;
    /**
     * 注册接口
     */
    @PostMapping("register")
    public String register(@RequestBody SysUser sysUser) {
        // 1.查询数据库有没有重复的用户名，如果有返回已存在用户，让他取登录就行了，不用再注册了
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, sysUser.getUsername());
        SysUser user = this.sysUserService.getOne(lambdaQueryWrapper);
        if (user != null) {
            return "数据存在账号，请登陆即可";
        }
        // 2.把用户的账号密码添加到数据库,在插入数据库之前，把密码加密处理
        System.out.println("加密之前的密码：" + sysUser.getPassword());
        String md5 = SecureUtil.md5(sysUser.getPassword());
        sysUser.setPassword(md5);
        System.out.println("加密之前的密码：" + sysUser.getPassword());
        boolean save = this.sysUserService.save(sysUser);
        if (save) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }

    /**
     * 登录接口
     * @return
     */
    @PostMapping("login")
    public String login(@RequestBody SysUser sysUser) {
        // 1.通过用户名查询账号信息
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, sysUser.getUsername());
        SysUser user = this.sysUserService.getOne(lambdaQueryWrapper);
        if (user == null) {
            return "用户不存在，请核验账户信息";
        }
        // 2.比对密码
        String md5 = SecureUtil.md5(sysUser.getPassword());
        boolean equals = StrUtil.equals(md5, user.getPassword());
        if (!equals) {
            return "用户名或密码错误";
        }
        // 3.返回token
        return this.sysUserTokenService.createToken(user.getId());
    }

    /**
     * 测试
     * @return
     */
    @GetMapping("hello")
    public String hello() {
        return "你好世界！";
    }
}
