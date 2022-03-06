package com.october.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.october.wiki.entity.Ebook;
import com.october.wiki.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("SELECT * FROM User WHERE name=#{name} and  password= #{password}")
    List<User> checkLogin(@Param("name") String name, @Param("password") String password);
}
