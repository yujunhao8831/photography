package com.cat.photography.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cat.photography.domain.ManageUser;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * 
 * @since 2023-05-15
 */
public interface ManageUserService extends IService< ManageUser > {

    ManageUser findByUsername(String username);
    
}
