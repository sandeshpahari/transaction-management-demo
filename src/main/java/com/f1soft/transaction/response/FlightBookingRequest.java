/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1soft.transaction.response;


import com.f1soft.transaction.entity.PassengerInfo;
import com.f1soft.transaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Sandesh Pahari <sandesh.pahari@f1soft.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    
    private PaymentInfo paymentInfo;
}
