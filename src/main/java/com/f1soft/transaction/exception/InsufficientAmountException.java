/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1soft.transaction.exception;

/**
 *
 * @author Sandesh Pahari <sandesh.pahari@f1soft.com>
 */
public class InsufficientAmountException extends RuntimeException{

    public InsufficientAmountException(String msg) {
        super(msg);
    }
    
}
