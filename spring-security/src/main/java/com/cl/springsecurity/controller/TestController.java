package com.cl.springsecurity.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther chenlong
 * @date 2021/6/1511:39
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test1")
    //@PostAuthorize("hasAnyRole('ADMIN')")
    public String test1(){
        return "ok";
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/test2")
    public String test2(){
        return "ok";
    }

    @RequestMapping("/toLoginPage")
    public String test3(){
        return "ok";
    }
}
