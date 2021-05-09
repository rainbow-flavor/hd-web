package com.rainbowflavor.hdcweb.controller;

import com.rainbowflavor.hdcweb.dto.SignupDto;
import com.rainbowflavor.hdcweb.string.ConstantUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping(value={ ConstantUrl.ROOT})
public class LoginController {

    @GetMapping
    public String rootPage(){
        return "redirect:/signin";
    }

    @GetMapping(value="/signin")
    public String loginPage(HttpServletRequest request){
        log.info("Login Controller = {}", request);
        return "page/signin";
    }

    @ResponseBody
    @PostMapping(value="/signup")
    public String signUp(@ModelAttribute SignupDto signupDto){
        log.info("signup obj = {}",signupDto);
        return "ok";
    }
}
