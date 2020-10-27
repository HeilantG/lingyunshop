package com.lingyun.service;

import com.lingyun.entity.util.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

public interface LoginUserService extends UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username);
}
