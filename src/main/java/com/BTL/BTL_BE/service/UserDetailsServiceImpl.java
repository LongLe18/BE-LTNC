/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.service;

/**
 *
 * @author ACER
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.BTL.BTL_BE.entity.AppUser;
import com.BTL.BTL_BE.Dao.AppUserDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired(required=true)
    AppUserDAO userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AppUser user = userRepository.findByuserName(username)
          .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
      return UserDetailsImpl.build(user);
    }
}
