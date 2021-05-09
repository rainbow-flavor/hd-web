package com.rainbowflavor.hdcweb.controller;

import com.rainbowflavor.hdcweb.dto.SignupDto;
import com.rainbowflavor.hdcweb.service.UserService;
import com.rainbowflavor.hdcweb.string.ConstantUrl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value={ ConstantUrl.ROOT})
@Controller
public class LoginController {

    private final UserService userService;

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
        userService.joinUser(signupDto);
        return "ok";
    }
}

