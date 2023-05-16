package com.cat.photography.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cat.photography.domain.SystemConfig;
import com.cat.photography.mapper.SystemConfigMapper;
import com.cat.photography.service.SystemConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置 服务实现类
 * </p>
 *
 * 
 * @since 2023-05-15
 */
@Service
public class SystemConfigServiceImpl extends ServiceImpl< SystemConfigMapper, SystemConfig > implements SystemConfigService {

}
