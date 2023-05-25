package com.tikora.webSocket.service;

import com.tikora.webSocket.models.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userModelRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.tikora.webSocket.models.User user  =userModelRepository.findByEmail(username).orElseThrow(() -> new NotFoundException("user not found"));
        return new User(user.getEmail(),user.getPassword(),new ArrayList<>());
    }
}
