package com.october.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.october.wiki.entity.Ebook;
import com.october.wiki.mapper.EbookMapper;
import com.october.wiki.service.EbookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements EbookService {

//private EbookMapper ebookMapper;
//    @Override
//    public List<Ebook> list(String name) {
//        ebookMapper.
//        return null;
//    }
}
