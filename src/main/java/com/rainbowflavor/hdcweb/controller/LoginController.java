package com.rainbowflavor.hdcweb.controller;

import com.rainbowflavor.hdcweb.string.ConstantUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping(value={ConstantUrl.LOGIN, ConstantUrl.ROOT})
public class LoginController {

    @GetMapping
    public String loginPage(HttpServletRequest request){
        log.info("Login Controller = {}", request);
        return "page/login";
    }
}
