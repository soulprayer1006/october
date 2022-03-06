package com.october.wiki.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.october.wiki.modules.system.entity.SysUser;
import com.october.wiki.modules.system.mapper.SysUserMapper;
import com.october.wiki.modules.system.service.ISysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
