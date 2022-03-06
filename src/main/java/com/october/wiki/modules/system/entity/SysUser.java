package com.october.wiki.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = -6324630285829739934L;
    @TableId
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Integer delFlag;
}
