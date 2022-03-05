package com.october.wiki.service;

import com.october.wiki.entity.TestEntity;
import com.october.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    public List<TestEntity> list(){
        return  testMapper.list();
    }
}
