package com.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class hellocontroller {
    @GetMapping("/hello")
    public  String hello(){
        return "hello world ! ";
    }
    @PostMapping("/hello")
    public String hellopost(@RequestBody String name){
        return "hello"+name+"!"; 
    }

}
