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
import com.BTL.BTL_BE.entity.AppRole;
import com.BTL.BTL_BE.entity.ERole;

@Repository
public interface AppRoleDAO extends JpaRepository<AppRole, Long>{
    Optional<AppRole> findByName(ERole name);
}
