package com.rainbowflavor.hdcweb.service;

import com.rainbowflavor.hdcweb.domain.ERole;
import com.rainbowflavor.hdcweb.domain.Role;
import com.rainbowflavor.hdcweb.domain.User;
import com.rainbowflavor.hdcweb.domain.UserRole;
import com.rainbowflavor.hdcweb.dto.SignupDto;
import com.rainbowflavor.hdcweb.repository.JpaRoleRepository;
import com.rainbowflavor.hdcweb.repository.JpaUserRepository;
import com.rainbowflavor.hdcweb.repository.JpaUserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RequiredArgsConstructor
@Service
public class UserService {
    private final JpaRoleRepository roleRepository;
    private final JpaUserRepository userRepository;
    private final JpaUserRoleRepository userRoleRepository;

    public SignupDto joinUser(SignupDto signupDto) {
        UserRole userRole = new UserRole();
        User user = User.builder()
                .name(signupDto.getName())
                .password(signupDto.getPassword())
                .birth(signupDto.getBirthday())
                .phone(signupDto.getPhone())
                .position(signupDto.getPosition())
                .email(signupDto.getEmail())
                .address(signupDto.getAddress())
                .build();

        User saveUser = userRepository.save(user);
        Role findRole = roleRepository.findByRole(ERole.ROLE_ADMIN);
        userRole.setUser(saveUser);
        userRole.setRole(findRole);
        UserRole saveUserRole = userRoleRepository.save(userRole);

        return null;
    }

    public User findUser(Long userId) {
        return userRepository.getOne(userId);
    }
}
