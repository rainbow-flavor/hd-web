package com.rainbowflavor.hdcweb.service;

import com.rainbowflavor.hdcweb.domain.User;
import com.rainbowflavor.hdcweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TestService {
    private final UserRepository userRepository;

    public Long join(User user){
        userRepository.save(user);
        return user.getId();
    }
}
