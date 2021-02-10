/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1soft.transaction.service;

import com.f1soft.transaction.repository.PassengerInfoRepo;
import com.f1soft.transaction.repository.PaymentInfoRepo;
import com.f1soft.transaction.entity.PassengerInfo;
import com.f1soft.transaction.entity.PaymentInfo;

import com.f1soft.transaction.response.FlightBookingResponse;
import com.f1soft.transaction.response.FlightBookingRequest;
import com.f1soft.transaction.utils.PaymentUtils;
import java.util.UUID;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sandesh Pahari <sandesh.pahari@f1soft.com>
 */
@Service 
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepo passengerInfoRepo;
    @Autowired
    private PaymentInfoRepo paymentInfoRepo;
    
   private final static Logger logger = LoggerFactory.getLogger(FlightBookingService.class);

    @Transactional
    public FlightBookingResponse bookFlightTicket(FlightBookingRequest request){
        PassengerInfo passengerinfo = request.getPassengerInfo();
        passengerInfoRepo.save(passengerinfo);
        
        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerinfo.getFare());
        logger.info("Insufficient Amount So Rollback to initial point!!!");
        paymentInfo.setPassengerId(passengerinfo.getPid());
        paymentInfo.setAmount(passengerinfo.getFare());
        paymentInfoRepo.save(paymentInfo);
        
        return new FlightBookingResponse("Sucess", passengerinfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerinfo);
    }
}
