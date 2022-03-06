package com.october.wiki.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserToken implements Serializable {
    private static final long serialVersionUID = 8961169453106948791L;
    @TableId
    private Long id;
    private Long userId;
    private Integer delFlag;
    private String token;
    private Date expireTime;
}
