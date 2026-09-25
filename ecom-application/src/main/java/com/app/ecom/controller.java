package com.app.ecom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class controller {
    private List<user> userList= new ArrayList<>();
    @GetMapping("/api/user")
    public List<user> getalluser(){
      //  HttpStatus
        return userList;
    }
    @PostMapping("/api/user")
    public List<user> getalluser(@RequestBody user user){
        userList.add(user);
        return userList;
    }
}
