package com.cat.photography.controller;

import com.cat.photography.common.ResponseEntityPro;
import com.cat.photography.domain.ManageUser;
import com.cat.photography.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/manageUser")
public class ManageUserController {

    @Autowired
    private ManageUserService manageUserService;

    @GetMapping("userList")
    public ResponseEntity< List<ManageUser> > userList() {
        return ResponseEntityPro.ok(manageUserService.list());
    }
}
