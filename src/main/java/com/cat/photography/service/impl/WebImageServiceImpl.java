package com.cat.photography.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cat.photography.domain.WebImage;
import com.cat.photography.mapper.WebImageMapper;
import com.cat.photography.service.WebImageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片 服务实现类
 * </p>
 *
 *
 * @since 2023-05-23
 */
@Service
public class WebImageServiceImpl extends ServiceImpl< WebImageMapper, WebImage > implements WebImageService {

}
