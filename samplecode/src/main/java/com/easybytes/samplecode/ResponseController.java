package com.easybytes.samplecode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @GetMapping(value = "/query")
    public String response()
    {
        return "Hellow world how are you";
    }
}
