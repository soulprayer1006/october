package com.october.wiki.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.october.wiki.modules.system.entity.SysUserToken;
import org.apache.ibatis.annotations.Select;

public interface SysUserTokenMapper extends BaseMapper<SysUserToken> {
    /**
     * 根据accessToken，查询用户信息
     *
     * @param token
     * @return
     */
    @Select("select * from sys_user_token where token = #{value} and del_flag = 0")
    SysUserToken queryByToken(String token);
}
