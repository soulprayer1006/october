package com.october.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.october.wiki.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> checkLogin(String name, String password);
}
