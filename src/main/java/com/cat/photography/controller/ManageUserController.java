package com.cat.photography.controller;

import com.cat.photography.common.JsonUtils;
import com.cat.photography.common.ResponseEntityPro;
import com.cat.photography.config.security.jwt.JwtTokenUtil;
import com.cat.photography.config.security.jwt.JwtUser;
import com.cat.photography.domain.ManageUser;
import com.cat.photography.service.ManageUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @since 2023-05-15
 */
@RestController
@RequestMapping( "/manageUser" )
public class ManageUserController {

    @Autowired
    private ManageUserService  manageUserService;
    @Autowired
    private JwtTokenUtil       jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @PreAuthorize( "hasAnyRole('ROLE_USER')" )
    @GetMapping( "get" )
    public ResponseEntity< JwtUser > get(@RequestHeader( "${jwt.header:Authorization}" ) final String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        if ( StringUtils.isBlank(username) ) {
            throw new AuthenticationCredentialsNotFoundException("无效token");
        }
        JwtUser user = ( JwtUser ) userDetailsService.loadUserByUsername(username);
        return ResponseEntityPro.ok(user , "-password");
    }

    @PreAuthorize( "hasAnyRole('ROLE_USER')" )
    @GetMapping( "userList" )
    public ResponseEntity< List< ManageUser > > userList() {
        return ResponseEntityPro.ok(manageUserService.list() , "-password");
    }

    @PreAuthorize( "hasAnyRole('ROLE_USER')" )
    @GetMapping( "{id}/userList" )
    public ResponseEntity< Object > idUserList() {

        String json = "{\"list\":[{\"id\":1,\"username\":\"admin\",\"fullName\":\"系统管理员2\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":202,\"username\":\"呼保义宋江 \",\"fullName\":\"天魁星 呼保义宋江 \",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":203,\"username\":\"玉麒麟卢俊义\",\"fullName\":\"天罡星 玉麒麟卢俊义\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":204,\"username\":\"智多星吴用\",\"fullName\":\"天机星 智多星吴用\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":205,\"username\":\"入云龙公孙胜\",\"fullName\":\"天闲星 入云龙公孙胜\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":206,\"username\":\"大刀关胜\",\"fullName\":\"天勇星 大刀关胜\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":207,\"username\":\"豹子头林冲\",\"fullName\":\"天雄星 豹子头林冲\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":208,\"username\":\"霹雳火秦明\",\"fullName\":\"天猛星 霹雳火秦明\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"NORMAL\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":209,\"username\":\"双鞭呼延灼\",\"fullName\":\"天威星 双鞭呼延灼\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"LOCKED\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"},{\"id\":210,\"username\":\"小李广花荣\",\"fullName\":\"天英星 小李广花荣\",\"avatar\":\"avatar.jpg\",\"gender\":\"MALE\",\"state\":\"LOCKED\",\"orgFullName\":\"根节点-水浒传\",\"createdTime\":\"2023-01-05 17:16:11\"}],\"total\":111}";


        return ResponseEntityPro.ok(JsonUtils.jsonToType(json , Map.class));    }


}
