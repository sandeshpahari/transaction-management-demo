/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1soft.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.f1soft.transaction.entity.PassengerInfo;

/**
 *
 * @author Sandesh Pahari <sandesh.pahari@f1soft.com>
 */
public interface PassengerInfoRepo extends JpaRepository<PassengerInfo,Long>{
    
}
