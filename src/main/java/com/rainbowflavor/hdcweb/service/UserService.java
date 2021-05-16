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
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final JpaRoleRepository roleRepository;
    private final JpaUserRepository userRepository;
    private final JpaUserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupDto joinUser(SignupDto signupDto) {
        signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));
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

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> findUser = userRepository.findByName(username);
        User user = findUser.orElseThrow(() -> new UsernameNotFoundException(username));
        log.debug("login user = {}",user);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles("ADMIN")
                .build();
    }
}
