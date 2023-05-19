package com.cat.photography.controller;


import com.cat.photography.common.LogUtils;
import com.cat.photography.common.ResponseEntityPro;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/image")
public class ImageController {



    @GetMapping("index")
    public ResponseEntity index() {
        try {
            final String imageList = FileUtils.readFileToString(new ClassPathResource("json/index.json").getFile() ,
                                                        StandardCharsets.UTF_8);
            return ResponseEntityPro.ok(imageList);

        } catch ( Exception e ) {
            LogUtils.getLogger().error("imageController.image.error" , e);
            return ResponseEntityPro.unprocessableEntity();
        }
    }

    @GetMapping("single")
    public ResponseEntity single() {
        try {
            final String imageList = FileUtils.readFileToString(new ClassPathResource("json/single.json").getFile() ,
                                                                StandardCharsets.UTF_8);
            return ResponseEntityPro.ok(imageList);

        } catch ( Exception e ) {
            LogUtils.getLogger().error("imageController.single.error" , e);
            return ResponseEntityPro.unprocessableEntity();
        }
    }
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

    @GetMapping("gallery")
    public ResponseEntity gallery(@RequestParam String tagCode ) {
        String path = null;
        if ( "tag_1".equals(tagCode) ) {
            path = "json/tag_1.json";
        }
        if ( "tag_2".equals(tagCode) ) {
            path = "json/tag_2.json";
        }
        if ( "tag_3".equals(tagCode) ) {
            path = "json/tag_3.json";
        }if ( "tag_4".equals(tagCode) ) {
            path = "json/tag_4.json";
        }
        if ( "tag_5".equals(tagCode) ) {
            path = "json/tag_5.json";
        }
        if ( "tag_6".equals(tagCode) ) {
            path = "json/tag_6.json";
        }
        if ( "tag_7".equals(tagCode) ) {
            path = "json/tag_7.json";
        }
        if ( "tag_8".equals(tagCode) ) {
            path = "json/tag_8.json";
        }
        if ( "tag_9".equals(tagCode) ) {
            path = "json/tag_9.json";
        }

        try {
            final String imageList = FileUtils.readFileToString(new ClassPathResource(path).getFile() ,
                                                                StandardCharsets.UTF_8);
            return ResponseEntityPro.ok(imageList);

        } catch ( Exception e ) {
            LogUtils.getLogger().error("imageController.services.error" , e);
            return ResponseEntityPro.unprocessableEntity();
        }
    }




}
