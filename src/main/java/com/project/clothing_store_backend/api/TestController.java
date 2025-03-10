package com.project.clothing_store_backend.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("visitor/test/{name}")
    public String test(@PathVariable String name){
        return "My name is "+name;
    }
}
