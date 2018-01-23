package com.engageok.prototype_1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.engageok.prototype_1.models.Role;
import com.engageok.prototype_1.models.User;
import com.engageok.prototype_1.repositories.UserRepo;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserRepo uRepo;
    public UserDetailsServiceImplementation(UserRepo uRepo){
        this.uRepo = uRepo;
    }
    // 1
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = uRepo.findByEmail(email);        
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }
    // 2
    private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}