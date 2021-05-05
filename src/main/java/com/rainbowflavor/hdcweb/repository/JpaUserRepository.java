package com.rainbowflavor.hdcweb.repository;

import com.rainbowflavor.hdcweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends JpaRepository<User, Long>{
}
