package com.rainbowflavor.hdcweb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class SignupDto {
    private String email;
    private String password;
    private String name;
    private String position;
    private String phone;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
