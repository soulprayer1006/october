package com.october.wiki.modules.system.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.october.wiki.modules.system.entity.SysUserToken;
import com.october.wiki.modules.system.mapper.SysUserTokenMapper;
import com.october.wiki.modules.system.service.ISysUserTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserToken> implements ISysUserTokenService {
    @Override
    public String createToken(long userId) {
        // 生成一个token
        String token = RandomUtil.randomString(32);

        // 当前的时间
        Date date = new Date();
        // 过期时间
        int EXPIRE = 3600 * 12;
        Date expireTime = new Date(date.getTime() + EXPIRE * 1000);
        // 判断是否生成过token
        LambdaQueryWrapper<SysUserToken> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserToken::getUserId, userId);
        SysUserToken sysUserToken = this.getOne(lambdaQueryWrapper);
        if (sysUserToken == null) {
            SysUserToken userToken = new SysUserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setExpireTime(expireTime);
            boolean save = this.save(userToken);
            if (save) {
                System.out.println("保存成功");
            } else {
                System.out.println("保存失败");
            }
        } else {
            sysUserToken.setToken(token);
            sysUserToken.setExpireTime(expireTime);
            boolean b = this.updateById(sysUserToken);
            if (b) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        }
        return token;
    }
}
