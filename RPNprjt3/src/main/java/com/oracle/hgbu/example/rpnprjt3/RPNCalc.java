/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.hgbu.example.rpnprjt3;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author JW
 */
public class RPNCalc {
    public static String[] getInput(){
        String expression;
        Scanner myScan = new Scanner(System.in);
        System.out.println("Enter a Reverse Polish Notation Expression: ");
        expression = myScan.nextLine();
        if(expression.length() == 0){
            throw new EmptyStackException("Invalid Input, no arguements");
        }
        String [] input;
        
        input = expression.split(" ");
        
        return input;
    }
    public static double calculateRPN(String[] expression) {
        
        Stack<String> stck = new Stack<String>();
 
        double returnValue = 0;
 
        String operators = "+-*/";
 
        for(String i : expression){
            if(!operators.contains(i)){
                stck.push(i);
            }
            else{
                if(stck.isEmpty() || stck.size() == 1){
                    throw new EmptyStackException("Can't pop values, Improper Arguement Size");
                }
                double num1 = Double.valueOf(stck.pop());
                double num2 = Double.valueOf(stck.pop());
                switch(operators.indexOf(i)){
                    case 0:
                        stck.push(String.valueOf(num1 + num2));
                        break;
                    case 1:
                        stck.push(String.valueOf(num2 - num1));
                        break;
                    case 2:
                        stck.push(String.valueOf(num1 * num2));
                        break;
                    case 3:
                        if(num1 == 0){
                            throw new DividebyZeroException("Improper Arithmetic, Divide by zero");
                        }
                        stck.push(String.valueOf(num2 / num1));
                        break;
                }
            }
        }
 
        returnValue = Double.parseDouble(stck.pop());
 
        return returnValue;

    }
}