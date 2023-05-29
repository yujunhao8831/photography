package com.cat.photography.controller;

import com.cat.photography.common.JsonUtils;
import com.cat.photography.common.ResponseEntityPro;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 系统配置 前端控制器
 * </p>
 *
 * @since 2023-05-15
 */
@RestController
@RequestMapping( "/systemConfig" )
public class SystemConfigController {


    @PreAuthorize( "hasAnyRole('ROLE_USER')" )
    @GetMapping( "menu" )
    public ResponseEntity< Object > get() {

        String json = "[{\n" +
                "\t\"id\": 2,\n" +
                "\t\"name\": \"仪表盘\",\n" +
                "\t\"url\": \"/dashboard\",\n" +
                "\t\"icon\": \"Odometer\",\n" +
                "\t\"parentId\": 1\n" +
                "}, {\n" +
                "\t\"id\": 3,\n" +
                "\t\"name\": \"系统管理\",\n" +
                "\t\"url\": \"/sys\",\n" +
                "\t\"icon\": \"SetUp\",\n" +
                "\t\"parentId\": 1\n" +
                "}, {\n" +
                "\t\"id\": 4,\n" +
                "\t\"name\": \"用户管理\",\n" +
                "\t\"url\": \"/users\",\n" +
                "\t\"icon\": \"User\",\n" +
                "\t\"parentId\": 3\n" +
                "}, {\n" +
                "\t\"id\": 5,\n" +
                "\t\"name\": \"角色管理\",\n" +
                "\t\"url\": \"/roles\",\n" +
                "\t\"icon\": \"Tickets\",\n" +
                "\t\"parentId\": 3\n" +
                "}, {\n" +
                "\t\"id\": 6,\n" +
                "\t\"name\": \"权限资源\",\n" +
                "\t\"url\": \"/resources\",\n" +
                "\t\"icon\": \"Collection\",\n" +
                "\t\"parentId\": 3\n" +
                "}, {\n" +
                "\t\"id\": 22,\n" +
                "\t\"name\": \"操作日志\",\n" +
                "\t\"url\": \"/logs\",\n" +
                "\t\"icon\": \"Timer\",\n" +
                "\t\"parentId\": 3\n" +
                "}]";

        return ResponseEntityPro.ok(JsonUtils.jsonToListType(json , Map.class));
    }


    @PreAuthorize( "hasAnyRole('ROLE_USER')" )
    @GetMapping( "resources" )
    public ResponseEntity< Object > resources() {

        String json = "[{\"id\":1,\"name\":\"tag_1\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_1_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_2\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_2_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_3\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_3_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_4\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_4_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_5\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_5_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_6\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_6_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_7\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_7_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_8\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_8_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false},{\"id\":1,\"name\":\"tag_9\",\"type\":\"DEPARTMENT\",\"children\":[{\"id\":1,\"name\":\"tag_9_detail\",\"type\":\"DEPARTMENT\",\"children\":[],\"isLeaf\":true}],\"isLeaf\":false}]";

        return ResponseEntityPro.ok(JsonUtils.jsonToListType(json , Map.class));
    }

}
