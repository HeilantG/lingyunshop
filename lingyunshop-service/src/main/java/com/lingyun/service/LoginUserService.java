package com.lingyun.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginUserService extends UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username);
}
