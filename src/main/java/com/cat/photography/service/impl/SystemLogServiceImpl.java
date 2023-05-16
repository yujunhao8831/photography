package com.cat.photography.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cat.photography.domain.SystemLog;
import com.cat.photography.mapper.SystemLogMapper;
import com.cat.photography.service.SystemLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * 
 * @since 2023-05-15
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl< SystemLogMapper, SystemLog > implements SystemLogService {

}
