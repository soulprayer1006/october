package com.october.wiki.controller;

import com.october.wiki.entity.TestEntity;
import com.october.wiki.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/test/list")
    public List<TestEntity> list() {
        return testService.list();
    }

}
