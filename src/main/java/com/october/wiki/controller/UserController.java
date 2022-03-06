package com.october.wiki.controller;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.october.wiki.entity.Ebook;
import com.october.wiki.entity.User;
import com.october.wiki.resp.CommonResp;
import com.october.wiki.service.EbookService;
import com.october.wiki.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @return
     */

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    //@ResponseBody
    public String checkLogin(@RequestParam("name") String name, @RequestParam("password") String password) {

        List<User> users = userService.checkLogin(name, password);
        if (!users.isEmpty()) {
            return "登录成功";
        } else {
            return "登录失败";
        }
    }




}






