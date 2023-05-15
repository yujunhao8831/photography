package com.cat.photography.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cat.photography.domain.ManageUser;
import com.cat.photography.mapper.ManageUserMapper;
import com.cat.photography.service.ManageUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-05-15
 */
@Service
public class ManageUserServiceImpl extends ServiceImpl< ManageUserMapper, ManageUser > implements ManageUserService {

}
