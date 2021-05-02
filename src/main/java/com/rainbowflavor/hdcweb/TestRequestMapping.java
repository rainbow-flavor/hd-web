package com.rainbowflavor.hdcweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestRequestMapping {

    @GetMapping
    public String index() {
        return "index";
    }
}