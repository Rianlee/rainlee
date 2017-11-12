package com.osm.antievil.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author airxiao
 * @DESCRIPTION
 * @create 2017 - 11 - 12 20:59
 */
public class SearchController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }
}
