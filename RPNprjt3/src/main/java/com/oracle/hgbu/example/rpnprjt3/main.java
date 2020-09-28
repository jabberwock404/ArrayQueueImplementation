/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.hgbu.example.rpnprjt3;

import static com.oracle.hgbu.example.rpnprjt3.RPNCalc.calculateRPN;
import static com.oracle.hgbu.example.rpnprjt3.RPNCalc.getInput;

/**
 *
 * @author JW
 */
public class main {
    public static void main(String[] args){
        //String[] input = new String[] {"23.3", "5", "16.2", "+", "8", "*", "-" ""};
        System.out.println(calculateRPN(getInput()));
    }
}
