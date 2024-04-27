package com.mgvsolutions.springjenkins.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/sample")
public class SampleController {
    

    @GetMapping("hello")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok("Hello Boss");
    }
    


}
