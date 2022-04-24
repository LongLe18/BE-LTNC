/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

/**
 *
 * @author ACER
 */

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BTL.BTL_BE.entity.AppUser;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByuserName(String username);
    Optional<AppUser> findByemail(String email);
    Optional<AppUser> findByuserId(String id);
    Boolean existsByuserName(String username);
    Boolean existsByemail(String email);
}
