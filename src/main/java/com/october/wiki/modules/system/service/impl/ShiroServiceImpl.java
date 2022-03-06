package com.october.wiki.modules.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.october.wiki.modules.system.entity.SysUser;
import com.october.wiki.modules.system.entity.SysUserToken;
import com.october.wiki.modules.system.mapper.SysUserMapper;
import com.october.wiki.modules.system.mapper.SysUserTokenMapper;
import com.october.wiki.modules.system.service.IShiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author oldwei
 * @date 2021/5/31 3:09 下午
 */
@Service
@RequiredArgsConstructor
public class ShiroServiceImpl implements IShiroService {

    private final SysUserMapper sysUserMapper;
    private final SysUserTokenMapper sysUserTokenMapper;
    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permissionsList;
        // 系统管理员拥有最高权限
//        if (userId == 1) {
//            List<SysMenu> menuEntityList = this.sysMenuMapper.selectList(null);
//            permissionsList = new ArrayList<>(menuEntityList.size());
//            for (SysMenu sysMenu :
//                    menuEntityList) {
//                permissionsList.add(sysMenu.getPerms());
//            }
//        } else {
//            permissionsList = this.sysUserMapper.queryAllPerms(userId);
//        }
        // 用户权限列表
//        Set<String> userPermissions = new HashSet<>();
//        for (String permissions :
//                permissionsList) {
//            if (StrUtil.isBlank(permissions)) {
//                continue;
//            }
//            userPermissions.addAll(Arrays.asList(permissions.trim().split(",")));
//        }
        return null;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return this.sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUser queryUser(Long userId) {
        return this.sysUserMapper.selectById(userId);
    }
}
