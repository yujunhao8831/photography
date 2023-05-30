package com.cat.photography.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ViewDispatchController {

    @RequestMapping("/image")
    public String userManage() {
        return "/image/index";
    }

}
