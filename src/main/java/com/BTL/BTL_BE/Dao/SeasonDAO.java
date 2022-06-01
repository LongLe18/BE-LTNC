/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BTL.BTL_BE.Dao;

import com.BTL.BTL_BE.entity.Season;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author nguye
 */
@Repository
public interface SeasonDAO extends JpaRepository<Season, Long> {
    List<Season> findAll();
    Season findByIDSeason(int id);
    
}
