package com.cat.photography.config.security.jwt;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



/**
 * @author pijingzhanji
 */
@Service("userDetailsService")
@CacheConfig( cacheNames = "userDetailsService" )
public class JwtUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	//	@Lazy
//	@Autowired
//	private UserService                   userService;
//
//
//	@Cacheable( key = "#username", condition = "#username != null" )
//	@Override
//	public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
//		if ( StringUtils.isBlank( username ) ) {
//			throw new UsernameNotFoundException( String.format( "该'%s'用户名不存在." , username ) );
//		}
//		User user = userService.findByUsername( username );
//		if ( user == null ) {
//			throw new UsernameNotFoundException( String.format( "该'%s'用户名不存在." , username ) );
//		}
//		return new JwtUser(
//			user.getId() ,
//			user.getUsername() ,
//			user.getPassword() ,
//			user.getNickName() ,
//			user.getRealName() ,
//			user.getEmail() ,
//			user.getPhone() ,
//			user.getUserImageUrl() ,
//			user.getLastPasswordResetDate() ,
//			user.getCreateUserId() ,
//			user.getCreateTime() ,
//			user.getUpdateTime() ,
//			user.getRemark() ,
//			user.getEnabled()
//		);
//	}



}










