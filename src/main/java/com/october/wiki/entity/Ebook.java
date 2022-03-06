package com.october.wiki.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ebook")
public class Ebook {
    @TableId
    private Long id;
    @TableField
    private String name;
    @TableField
    private Long category1Id;
    @TableField
    private Long category2Id;
    @TableField
    private String description;
    @TableField
    private String cover;
    @TableField
    private Integer docCount;
    @TableField
    private Integer viewCount;
    @TableField
    private Integer voteCount;

}