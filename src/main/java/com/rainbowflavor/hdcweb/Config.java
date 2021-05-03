package com.rainbowflavor.hdcweb;

import com.rainbowflavor.hdcweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@ComponentScan
@Configuration
public class Config {
    private final UserRepository userRepository;

}
