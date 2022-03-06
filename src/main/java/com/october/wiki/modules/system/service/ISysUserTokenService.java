package com.october.wiki.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.october.wiki.modules.system.entity.SysUserToken;

public interface ISysUserTokenService extends IService<SysUserToken> {
    String createToken(long userId);
}
