package kz.aitu.rest2423.restpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/main")
    public String Mylistener()
    {
        return "Hello World";
    }
}
