package com.cat.photography.controller;

import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * 
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/systemLog")
public class SystemLogController {

    @PostMapping( "/upload" )
    @ResponseBody
    public String save(@RequestParam( "file" ) MultipartFile file) throws IOException {
        final String pathname = "/Users/pijingzhanji/Documents/git/spring-boot-adminlte/" + file.getName();
        FileSystemUtils.copyRecursively(file.getResource().getFile() ,
                                        new File(pathname));
        return pathname;

    }

}
