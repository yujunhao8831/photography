package com.cat.photography.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cat.photography.common.LogUtils;
import com.cat.photography.common.PagingRequest;
import com.cat.photography.common.ResponseEntityPro;
import com.cat.photography.domain.WebImage;
import com.cat.photography.service.WebImageService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private WebImageService webImageService;

    @GetMapping("services")
    public ResponseEntity services() {
        try {
            final String imageList = FileUtils.readFileToString(new ClassPathResource("json/services.json").getFile() ,
                                                                StandardCharsets.UTF_8);
            return ResponseEntityPro.ok(imageList);

        } catch ( Exception e ) {
            LogUtils.getLogger().error("imageController.services.error" , e);
            return ResponseEntityPro.unprocessableEntity();
        }
    }

    @GetMapping( "index" )
    public ResponseEntity< List< WebImage > > index() {
        return ResponseEntityPro.ok(webImageService.list());
    }


    @GetMapping("gallery")
    public ResponseEntity<WebImage> gallery(@RequestParam String tagCode ) {
        final QueryWrapper< WebImage > wrapper = new QueryWrapper<>();
        return ResponseEntityPro.ok(webImageService.getOne(wrapper.eq("TAG_CODE" , tagCode)));
    }


    @GetMapping( "admin/list" )
    public ResponseEntity<Page< WebImage >> list(PagingRequest pagingRequest) {
        return ResponseEntityPro.ok(webImageService.page(new Page<>(pagingRequest.getPageNumber() ,
                                                                    pagingRequest.getPageSize())));
    }

    @RequestMapping( "upload" )
    @ResponseBody
    public ResponseEntity< Map< String, Object > > upload(@RequestParam MultipartFile file) throws IOException {
        final String pathname = "D:\\idea-git\\photography\\src\\main\\resources\\upload\\" + file.getName();
        FileUtils.copyFile(file.getResource().getFile() , new File(pathname) );
        return new ResponseEntityPro().add("pathname" , pathname).buildOk();
    }


}
