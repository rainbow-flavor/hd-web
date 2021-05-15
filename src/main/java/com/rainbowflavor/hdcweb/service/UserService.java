package com.rainbowflavor.hdcweb.service;

import com.rainbowflavor.hdcweb.domain.ERole;
import com.rainbowflavor.hdcweb.domain.Role;
import com.rainbowflavor.hdcweb.domain.User;
import com.rainbowflavor.hdcweb.domain.UserRole;
import com.rainbowflavor.hdcweb.dto.SignupDto;
import com.rainbowflavor.hdcweb.mapstruct.sign.SignupMapper;
import com.rainbowflavor.hdcweb.repository.JpaRoleRepository;
import com.rainbowflavor.hdcweb.repository.JpaUserRepository;
import com.rainbowflavor.hdcweb.repository.JpaUserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final JpaRoleRepository roleRepository;
    private final JpaUserRepository userRepository;
    private final JpaUserRoleRepository userRoleRepository;

    @Transactional
    public SignupDto joinUser(SignupDto signupDto) {
        User user = SignupMapper.INSTANCE.toEntity(signupDto);

        User saveUser = userRepository.save(user);
        Role findRole = roleRepository.findByRole(ERole.ROLE_ADMIN);

        UserRole userRole = new UserRole();
        userRole.setUser(saveUser);
        userRole.setRole(findRole);

        userRoleRepository.save(userRole);

        return SignupMapper.INSTANCE.toDto(saveUser);
    }

    public User findUser(Long userId) {
        return userRepository.getOne(userId);
    }

    public User findUser(Long userId) {
        return userRepository.getOne(userId);
    }
}
