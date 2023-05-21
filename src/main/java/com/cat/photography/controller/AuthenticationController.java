package com.cat.photography.controller;

import com.cat.photography.common.ResponseEntityPro;
import com.cat.photography.config.security.jwt.JwtTokenUtil;
import com.cat.photography.config.security.jwt.JwtUser;
import com.cat.photography.domain.ManageUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.Date;

/**
 * 授权认证控制器
 *
 * @author pijingzhanji
 */
//@Pass
@RestController
@RequestMapping( "authentication" )
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil          jwtTokenUtil;
	@Autowired
	private UserDetailsService    userDetailsService;

	/**
	 * 认证
	 *
	 * @param user   : 表单
	 * @return token
	 * @throws AuthenticationException 认证失败则会抛异常
	 */
	@PostMapping
	public ResponseEntity createAuthenticationToken ( @RequestBody ManageUser user) throws AuthenticationException {
		// 执行安全认证
		final Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				user.getUsername() ,
				user.getPassword()
			)
		);
		SecurityContextHolder.getContext().setAuthentication( authentication );
		final UserDetails userDetails = ( UserDetails ) authentication.getPrincipal();
		final String      token       = jwtTokenUtil.generateToken( userDetails );
		// 返回
        return new ResponseEntityPro().add("token" , token)
                                      .add("user" , userDetails)
                                      .flushBodyByFilterFields(
                                              "*,-user.password,-user.lastPasswordResetDate,-user.createTime,-user.updateTime,-user.remark,-user.enabled"
                                      ).buildOk();
    }

	/**
	 * 刷新并认证token
	 *
	 * @return token
	 */
	@PutMapping
	public ResponseEntity refreshAndGetAuthenticationToken ( @RequestHeader( "${jwt.header:Authorization}" ) final String token ) {
		String username = jwtTokenUtil.getUsernameFromToken( token );
		if ( StringUtils.isBlank( username ) ) {
			throw new AuthenticationCredentialsNotFoundException( "无效token" );
		}
		JwtUser user = ( JwtUser ) userDetailsService.loadUserByUsername(username );
		if ( jwtTokenUtil.canTokenBeRefreshed(token , Date.from(user.getLastPasswordResetDate().atZone(ZoneId.systemDefault()).toInstant()) ) ) {
			String refreshedToken = jwtTokenUtil.refreshToken( token );
			return new ResponseEntityPro().add( "token" , refreshedToken ).buildOk();
		} else {
			return ResponseEntityPro.badRequest( "原 token 无效" );
		}
	}

}
