/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1soft.transaction.controller;

import com.f1soft.transaction.response.FlightBookingRequest;
import com.f1soft.transaction.response.FlightBookingResponse;
import com.f1soft.transaction.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author Sandesh Pahari <sandesh.pahari@f1soft.com>
 */
@RestController
public class BookingController {
    
    @Autowired
    private FlightBookingService service;
    
    @PostMapping("/bookFlightTicket")
    public FlightBookingResponse bookFlightTicket(@RequestBody FlightBookingRequest request){
        return service.bookFlightTicket(request);
    }
    
}
