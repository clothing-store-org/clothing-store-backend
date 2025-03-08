package com.project.clothing_store_backend.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("/{name}")
    public String test(@PathVariable String name){
        return "My name is "+name;
    }
}
