package com.lingyun.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginShangJiaService extends UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username);
}
