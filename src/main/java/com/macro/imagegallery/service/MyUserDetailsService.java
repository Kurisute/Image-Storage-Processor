//package com.macro.imagegallery.service;
//
////import com.gpch.login.model.Role;
//import com.macro.imagegallery.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String userName) {
//        User user = userService.findUserByUserName(userName);
//        HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//        return buildUserForAuthentication(user, authorities);
//    }
//
//
//    private UserDetails buildUserForAuthentication(User user, HashSet<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                true, true, true, true, authorities);
//    }
//}
