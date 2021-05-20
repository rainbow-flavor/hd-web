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
        return "redirect:/index";
    }

    @GetMapping(value="/login")
    public String loginPage(){
        log.info("Login Controller Path = /login");
        return "page/signin";
    }

    @PostMapping(value="/signup")
    public String signUp(@ModelAttribute SignupDto signupDto){
        log.info("signup controller = {}", signupDto);
        userService.joinUser(signupDto);
        return "redirect:/signin";
    }
}

