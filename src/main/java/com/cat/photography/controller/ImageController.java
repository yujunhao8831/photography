package com.cat.photography.controller;


import com.cat.photography.common.LogUtils;
import com.cat.photography.common.ResponseEntityPro;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
