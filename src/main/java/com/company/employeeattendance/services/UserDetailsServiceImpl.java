package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.CustomAuth;
import com.company.employeeattendance.entities.User;
import com.company.employeeattendance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameAndActive(username, 1);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found " + username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

/*        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }*/

        return new CustomAuth(user, user.getUserName(), user.getPassword(), true, true, true, true, new ArrayList<>());
    }


}
