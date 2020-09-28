/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.hgbu.example.rpnprjt3;

/**
 *
 * @author JW
 */
public class DividebyZeroException extends ArithmeticException {
    public DividebyZeroException(String err){
        super(err);
    }    
}
