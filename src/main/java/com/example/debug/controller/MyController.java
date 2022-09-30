package com.example.debug.controller;

import com.example.debug.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("test")
    public List<String> test() {

        List<String> nameList = myService.getAllNames();

        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            System.out.println("名字為: " + name);
        }

        return nameList;
    }


    @GetMapping("test2")
    public String test2() {

        List<String> nameList = myService.getAllNames();

        return nameList.stream()
                .filter(name -> name.equals("Amy"))
                .findFirst()
                .orElse(null);
    }
}
