package com.rainbowflavor.hdcweb.mapstruct.sign;

import com.rainbowflavor.hdcweb.domain.User;
import com.rainbowflavor.hdcweb.dto.SignupDto;
import com.rainbowflavor.hdcweb.mapstruct.GenericMapper;
import org.mapstruct.Mapper;

@Mapper
public interface SignupMapper extends GenericMapper<SignupDto, User> {
}
