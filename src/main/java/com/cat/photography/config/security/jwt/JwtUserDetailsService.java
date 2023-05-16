package com.cat.photography.config.security.jwt;


import com.cat.photography.domain.ManageUser;
import com.cat.photography.service.ManageUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author pijingzhanji
 */
@Service( "userDetailsService" )
@CacheConfig( cacheNames = "userDetailsService" )
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ManageUserService manageUserService;


    @Cacheable( key = "#username", condition = "#username != null" )
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ( StringUtils.isBlank(username) ) {
            throw new UsernameNotFoundException(String.format("该'%s'用户名不存在." , username));
        }
        ManageUser user = manageUserService.findByUsername(username);
        if ( user == null ) {
            throw new UsernameNotFoundException(String.format("该'%s'用户名不存在." , username));
        }
        return new JwtUser(
                user.getId() ,
                user.getUsername() ,
                user.getPassword() ,
                user.getNickName() ,
                user.getRealName() ,
                user.getEmail() ,
                user.getPhone() ,
                user.getLastPasswordResetDate() ,
                user.getCreateTime() ,
                user.getUpdateTime() ,
                user.getRemark() ,
                user.getIsEnabled()
        );
    }


}










