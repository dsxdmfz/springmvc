package com.springmvc.handles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangl on 2017/5/14.
 */
@Controller
public class Helloworld {

    /**
     * 1、使用@RequestMapping 注解来映射请求的URL
     * 2、返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver 视图解析器，会做如下的解析：
     * 通过prefix + returnVal + 后缀 这样的方式得到实际的物理视图，然后做转发操作
     *
     *
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("Hello World");
        return "success";
    }
}
