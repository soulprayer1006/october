package com.october.wiki.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.october.wiki.entity.Ebook;
import com.october.wiki.entity.User;
import com.october.wiki.mapper.EbookMapper;
import com.october.wiki.mapper.UserMapper;
import com.october.wiki.service.EbookService;
import com.october.wiki.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@DS("XXX") //动态数据
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



    @Resource
    private UserMapper userMapper;




    @Override
    public List<User> checkLogin(String name, String password) {
        return userMapper.checkLogin(name, password);
    }
}
