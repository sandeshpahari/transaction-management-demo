/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1soft.transaction.utils;

import com.f1soft.transaction.exception.InsufficientAmountException;
import com.f1soft.transaction.service.FlightBookingService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sandesh Pahari <sandesh.pahari@f1soft.com>
 */
public class PaymentUtils {
     
    private static Map<String, Double> paymentMap = new HashMap<>();
    static {
        paymentMap.put("acc1", 2000.0);
        paymentMap.put("acc2", 5000.0);
        paymentMap.put("acc3", 6000.0);
        paymentMap.put("acc4", 8000.0);
    }
    
    public static boolean validateCreditLimit(String accNo, double paidAmount){
        if (paidAmount>paymentMap.get(accNo)) {
            throw new InsufficientAmountException("Isufficient Amount..| ");
            
        }else{
            return true;
        }
    }
}
